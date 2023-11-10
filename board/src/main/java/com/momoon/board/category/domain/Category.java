package com.momoon.board.category.domain;

public class Category {

    private Long id;

    private String name;

    private LoginAccess loginAccess;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LoginAccess getLoginAccess() {
        return loginAccess;
    }

    public Category() {

    }

    public Category(builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.loginAccess = builder.loginAccess;
    }

    public static class builder{

        private Long id;
        private String name;
        private LoginAccess loginAccess;

        public builder id(Long id) {
            this.id = id;
            return this;
        }

        public builder name(String name) {
            this.name = name;
            return this;
        }

        public builder loginAccess(LoginAccess loginAccess) {
            this.loginAccess = loginAccess;
            return this;
        }

        public Category build() {
            return new Category(this);
        }

    }
}
