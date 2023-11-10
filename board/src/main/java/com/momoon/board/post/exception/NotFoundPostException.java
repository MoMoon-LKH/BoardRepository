package com.momoon.board.post.exception;

public class NotFoundPostException extends RuntimeException{
    public NotFoundPostException() {
        super("해당 게시물을 찾을 수 없습니다");
    }
}
