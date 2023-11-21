package com.momoon.board.setting.exception;

import com.momoon.board.common.domain.HttpStatusInfo;

public class ForbiddenException extends BaseException{

    public ForbiddenException() {
        super(HttpStatusInfo.FORBIDDEN);
    }
}
