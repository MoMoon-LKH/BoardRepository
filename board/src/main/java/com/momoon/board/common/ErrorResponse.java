package com.momoon.board.common;

public class ErrorResponse {

    private String status;

    private String message;



    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }


    public ErrorResponse(builder builder) {
        this.status = builder.status;
        this.message = builder.message;
    }

    public static class builder {

        private String status;
        private String message;

        public builder status(String status) {
            this.status = status;
            return this;
        }

        public builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }
}
