package com.momoon.board.token.exception;

public class NotValidateTokenException extends RuntimeException{
    public NotValidateTokenException() {
        super("유효한 토큰 정보가 아닙니다");
    }
}
