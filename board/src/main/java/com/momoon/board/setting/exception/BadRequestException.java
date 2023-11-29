package com.momoon.board.setting.exception;

import com.momoon.board.common.domain.HttpStatusInfo;

public class BadRequestException extends BaseException{

    public BadRequestException() {
        super(HttpStatusInfo.BAD_REQUEST);
    }
}
