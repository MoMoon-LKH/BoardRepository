package com.momoon.board.token.domain;

public class TokenDto {

    private String access;

    private String refresh;


    public TokenDto() {
    }

    public TokenDto(builder builder) {
        this.access = builder.access;
        this.refresh = builder.refresh;
    }

    public String getAccess() {
        return access;
    }

    public String getRefresh() {
        return refresh;
    }

    public static class builder {

        private String access;

        private String refresh;

        public builder access(String access) {
            this.access = access;
            return this;
        }

        public builder refresh(String refresh) {
            this.refresh = refresh;
            return this;
        }

        public TokenDto build() {
            return new TokenDto(this);
        }
    }
}
