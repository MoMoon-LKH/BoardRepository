package com.momoon.board.common.exception;

public class NotFoundDomainException extends RuntimeException{

    public NotFoundDomainException(String message) {
        super(message);
    }
}
