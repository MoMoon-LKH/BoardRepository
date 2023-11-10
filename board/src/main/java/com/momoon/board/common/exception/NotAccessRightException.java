package com.momoon.board.common.exception;

public class NotAccessRightException extends RuntimeException{
    public NotAccessRightException() {
        super("접근 권한이 없습니다");
    }
}
