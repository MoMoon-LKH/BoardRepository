package com.momoon.board.setting.exception;


import com.momoon.board.common.domain.HttpStatusInfo;
import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    private String message;

    private HttpStatus httpStatus;

    public BaseException(HttpStatusInfo httpStatus) {
        this.message = httpStatus.getMessage();
        this.httpStatus = httpStatus.getHttpStatus();
    }


    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

