package com.momoon.board.token.domain;

import java.time.LocalDate;

public class TokenInfo {

    private Long memberId;

    private String tokenValue;

    private LocalDate createDate;

    public Long getMemberId() {
        return memberId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    private TokenInfo(builder builder) {
        this.memberId = builder.memberId;
        this.tokenValue = builder.tokenValue;
        this.createDate = builder.createDate;
    }

    public static class builder{

        private Long memberId;
        private String tokenValue;
        private LocalDate createDate;

        public builder memberId(Long memberId) {
            this.memberId = memberId;
            return this;
        }

        public builder tokenValue(String tokenValue) {
            this.tokenValue = tokenValue;
            return this;
        }

        public builder createDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }

        public TokenInfo build(){
            return new TokenInfo(this);
        }
    }
}
