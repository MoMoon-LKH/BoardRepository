package com.momoon.board.member.domain;

import java.time.LocalDateTime;

public class MemberDto {

    private Long id;

    private String loginId;

    private String name;

    private String nickname;

    private String email;

    private String phone;

    private LocalDateTime createDate;

    public MemberDto() {

    }

    public MemberDto(builder builder) {
        this.loginId = builder.loginId;
        this.name = builder.name;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.createDate = builder.createDate;
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
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

    public static class builder {

        private String loginId;

        private String name;

        private String nickname;

        private String email;

        private String phone;

        private LocalDateTime createDate;

        public builder loginId(String loginId) {
            this.loginId = loginId;
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

        public MemberDto build() {
            return new MemberDto(this);
        }
    }
}
