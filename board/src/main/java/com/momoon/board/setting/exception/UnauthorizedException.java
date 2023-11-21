package com.momoon.board.setting.exception;

import com.momoon.board.common.domain.HttpStatusInfo;

public class UnauthorizedException extends BaseException{

    public UnauthorizedException() {
        super(HttpStatusInfo.UNAUTHORIZED);
    }
}
