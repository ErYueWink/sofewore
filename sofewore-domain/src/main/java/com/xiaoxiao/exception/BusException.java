package com.xiaoxiao.exception;

import com.xiaoxiao.util.CodeEnum;

public class BusException extends RuntimeException{

    private Integer code;
    private String msg;

    public BusException() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BusException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public BusException(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
