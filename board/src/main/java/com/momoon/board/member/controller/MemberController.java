package com.momoon.board.member.controller;

import com.momoon.board.member.domain.LoginDto;
import com.momoon.board.member.domain.Member;
import com.momoon.board.member.domain.MemberDto;
import com.momoon.board.member.domain.RegisterDto;
import com.momoon.board.member.service.MemberService;
import com.momoon.board.token.domain.TokenDto;
import com.momoon.board.token.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    private final TokenService tokenService;

    public MemberController(MemberService memberService, TokenService tokenService) {
        this.memberService = memberService;
        this.tokenService = tokenService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public MemberDto signup(@RequestBody RegisterDto registerDto) {

        Member member = memberService.registerMember(registerDto);
        return memberService.findById(member.getId());
    }

    @GetMapping("/duplicate-id")
    public ResponseEntity<?> duplicateId(@RequestParam("id") String id) {
        return ResponseEntity.ok(memberService.existLoginId(id));
    }

    @GetMapping("/duplicate-nickname")
    public ResponseEntity<?> duplicateNickname(@RequestParam("nickname") String nickname) {
        return ResponseEntity.ok(memberService.existNickname(nickname));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {

        Member member = memberService.login(loginDto);

        TokenDto token = tokenService.createLoginToken(loginDto.getLoginId(), member.getId());

        return ResponseEntity.ok(token);
    }

}
