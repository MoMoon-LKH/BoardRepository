package com.momoon.board.common.domain;

import org.springframework.http.HttpStatus;

public enum HttpStatusInfo {
    NOT_FOUND("40400", "Not Found", HttpStatus.NOT_FOUND),
    BAD_REQUEST("40000", "Bad Request", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("40100", "Unauthorized", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("40400", "Forbidden", HttpStatus.FORBIDDEN);


    private final String message;

    private final String status;

    private final HttpStatus httpStatus;

    HttpStatusInfo(String message, String status, HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
