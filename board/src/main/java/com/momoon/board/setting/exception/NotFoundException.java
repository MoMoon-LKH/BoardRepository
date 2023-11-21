package com.momoon.board.setting.exception;

import com.momoon.board.common.domain.HttpStatusInfo;

public class NotFoundException extends BaseException{

    public NotFoundException() {
        super(HttpStatusInfo.NOT_FOUND);
    }
}
