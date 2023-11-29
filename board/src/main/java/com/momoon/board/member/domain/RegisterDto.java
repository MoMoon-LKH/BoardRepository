package com.momoon.board.member.domain;

public class RegisterDto {

    private String loginId;

    private String password;

    private String name;

    private String nickname;

    private String email;

    private String phone;

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
