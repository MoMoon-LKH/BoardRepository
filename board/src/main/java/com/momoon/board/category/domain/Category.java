package com.momoon.board.category.domain;

public class Category {

    private Long id;

    private String name;

    private LoginType loginType;

    public Category() {}

    public Category(builder builder) {
        this.name = builder.name;
        this.loginType = builder.loginType;
    }


    public static class builder {

        private String name;
        private LoginType loginType;

        public builder name(String name) {
            this.name = name;
            return this;
        }

        public builder loginType(LoginType loginType) {
            this.loginType = loginType;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LoginType getLoginType() {
        return loginType;
    }
}
