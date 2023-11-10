package com.momoon.board.token.exception;

import com.momoon.board.common.ErrorResponse;
import com.momoon.board.common.exception.NotFoundDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NotFoundTokenException extends RuntimeException{

    public NotFoundTokenException() {
        super("토큰 정보가 없습니다");
    }
}
