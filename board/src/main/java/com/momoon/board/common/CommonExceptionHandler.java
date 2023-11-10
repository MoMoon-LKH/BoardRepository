package com.momoon.board.common;

import com.momoon.board.common.exception.NotAccessRightException;
import com.momoon.board.common.exception.NotFoundDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(NotFoundDomainException.class)
    public ResponseEntity<ErrorResponse> notFoundDomainHandler(NotFoundDomainException e) {
        ErrorResponse errorResponse = new ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NotAccessRightException.class)
    public ResponseEntity<ErrorResponse> handleNotAccessRightException(NotAccessRightException e) {
        ErrorResponse errorResponse = new ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
