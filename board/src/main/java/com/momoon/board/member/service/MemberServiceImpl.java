package com.momoon.board.member.service;

import com.momoon.board.common.exception.NotFoundException;
import com.momoon.board.member.domain.LoginDto;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.domain.MemberDto;
import com.momoon.board.member.domain.RegisterDto;
import com.momoon.board.member.repository.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    @Transactional
    public Member registerMember(RegisterDto registerDto) {

        Member member = new Member.builder()
                .loginId(registerDto.getLoginId())
                .password(registerDto.getPassword())
                .name(registerDto.getName())
                .nickname(registerDto.getNickname())
                .phone(registerDto.getPhone())
                .email(registerDto.getEmail())
                .build();

        memberMapper.registerMember(member);

        return member;
    }

    @Override
    public boolean existLoginId(String loginId) {
        return memberMapper.countByLoginId(loginId) > 0;
    }

    @Override
    public boolean existNickname(String nickname) {
        return memberMapper.countByNickname(nickname) > 0;
    }

    @Override
    public MemberDto findById(Long id) {
        return memberMapper.findById(id).orElseThrow(() -> new NotFoundException("해당 회원을 찾지 못하였습니다"));
    }

    public Member login(LoginDto loginDto){
        return memberMapper.findByLoginIdAndPassword(loginDto).orElseThrow(() -> new NotFoundException("아이디와 비밀번호가 다릅니다"));
    }
}
