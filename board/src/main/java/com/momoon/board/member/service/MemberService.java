package com.momoon.board.member.service;

import com.momoon.board.member.domain.Member;
import com.momoon.board.member.dto.LoginDto;
import com.momoon.board.member.dto.RegisterDto;
import com.momoon.board.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerMember(RegisterDto register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));

        Member member = new Member.builder()
                .memberId(register.getMemberId())
                .password(register.getPassword())
                .name(register.getName())
                .nickname(register.getNickname())
                .email(register.getEmail())
                .phone(register.getPhone())
                .build();

        return memberRepository.registerMember(member) > 0;
    }

    public boolean existMemberId(String memberId) {
        return memberRepository.countByMemberId(memberId) > 0;
    }

    public boolean existNickname(String nickname) {
        return memberRepository.countByNickname(nickname) > 0;
    }

    public Member login(LoginDto loginDto) {

        Member member = memberRepository.findByMemberId(loginDto.getMemberId());

        if (member != null && passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {

            return member;
        } else {
            return null;
        }
    }

}
