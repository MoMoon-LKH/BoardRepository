package com.momoon.board.member.controller;

import com.momoon.board.member.domain.Member;
import com.momoon.board.member.dto.LoginDto;
import com.momoon.board.member.dto.RegisterDto;
import com.momoon.board.member.service.MemberService;
import com.momoon.board.token.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    public MemberController(MemberService memberService, TokenProvider tokenProvider) {
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody RegisterDto registerDto) {

        boolean bool = memberService.registerMember(registerDto);
        Map<String, Object> map = new HashMap<>();
        map.put("success", bool);
        map.put("message", "가입 완료되었습니다");

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }


    @GetMapping("/duplicate-id")
    public ResponseEntity<?> duplicateId(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<>();
        boolean bool = memberService.existMemberId(id);

        map.put("exist", bool);
        map.put("message", duplicateMessage(bool, "아이디"));

        return ResponseEntity.ok(map);
    }

    @GetMapping("/duplicate-nickname")
    public ResponseEntity<?> duplicateNickname(@RequestParam("nickname") String nickname) {
        Map<String, Object> map = new HashMap<>();
        boolean bool = memberService.existNickname(nickname);

        map.put("exist", bool);
        map.put("message", duplicateMessage(bool, "닉네임"));

        return ResponseEntity.ok(map);
    }

    private String duplicateMessage(boolean bool, String type) {
        return bool ? "이미 존재하는 " + type + "입니다" : "사용가능한 " + type + "입니다";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto, HttpServletResponse response) {

        Member member = memberService.login(loginDto);
        Map<String, Object> map = new HashMap<>();

        if(member == null){
            map.put("message", "아이디와 비밀번호를 다시 확인해주세요");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }

        map.put("token", tokenProvider.createAccessToken(member.getMemberId()));
        map.put("message", "성공적으로 로그인 되어있습니다");

        response.addCookie(tokenProvider.createRefreshCookie(member.getMemberId()));

        return ResponseEntity.ok(map);
    }
}
