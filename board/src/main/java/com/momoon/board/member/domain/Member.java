package com.momoon.board.member.domain;

import java.time.LocalDateTime;

public class Member {

    private Long id;

    private String loginId;

    private String password;

    private String name;

    private String nickname;

    private String email;

    private String phone;

    private LocalDateTime createDate;

    public Member() {
    }

    public Member(builder builder) {
        this.loginId = builder.loginId;
        this.password = builder.password;
        this.name = builder.name;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.createDate = builder.createDate;
    }


    public static class builder {
        private String loginId;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private String phone;
        private LocalDateTime createDate;

        public builder loginId(String loginId) {
            this.loginId = loginId;
            return this;
        }

        public builder password(String password) {
            this.password = password;
            return this;
        }

        public builder name(String name) {
            this.name = name;
            return this;
        }

        public builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public builder email(String email) {
            this.email = email;
            return this;
        }

        public builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public builder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    public Long getId() {
        return id;
    }

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

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}
