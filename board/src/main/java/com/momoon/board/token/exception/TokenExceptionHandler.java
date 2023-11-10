package com.momoon.board.token.exception;

import com.momoon.board.common.ErrorResponse;
import com.momoon.board.common.exception.NotFoundDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TokenExceptionHandler {


    @ExceptionHandler(NotFoundTokenException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundTokenException(NotFoundDomainException e) {
        ErrorResponse errorResponse = new ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NotValidateTokenException.class)
    public ResponseEntity<ErrorResponse> handleNotValidateTokenException(NotValidateTokenException e) {
        ErrorResponse errorResponse = new ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
