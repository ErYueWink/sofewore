package com.xiaoxiao.util;

import org.springframework.http.HttpStatus;

public enum CodeEnum {
    REQUEST_SUCCESS(200,"SUCCESS"),
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SYSTEM_ERROR");

    private final Integer code;
    private final String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
