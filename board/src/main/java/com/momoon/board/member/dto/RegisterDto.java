package com.momoon.board.member.dto;


import javax.validation.constraints.*;

public class RegisterDto {

    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min = 4, message = "아이디 4글자 이상 입력해주세요")
    private String memberId;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, message = "아이디 8글자 이상 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

    @Email
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "핸드폰 번호를 입력해주세요")
    private String phone;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
