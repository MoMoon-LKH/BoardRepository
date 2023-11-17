package com.momoon.board.member.service;

import com.momoon.board.member.domain.LoginDto;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.domain.MemberDto;
import com.momoon.board.member.domain.RegisterDto;

import java.security.NoSuchAlgorithmException;

public interface MemberService {

    Member registerMember(RegisterDto registerDto);

    boolean existLoginId(String loginId);

    boolean existNickname(String nickname);

    MemberDto findById(Long id);

    Member login(LoginDto loginDto);
}
