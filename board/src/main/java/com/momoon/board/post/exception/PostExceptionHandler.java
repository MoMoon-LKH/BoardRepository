package com.momoon.board.post.exception;

import com.momoon.board.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(NotFoundPostException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundPostException(NotFoundPostException e) {
        ErrorResponse errorResponse = new ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.toString())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
