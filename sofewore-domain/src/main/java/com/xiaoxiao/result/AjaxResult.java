package com.xiaoxiao.result;

public class AjaxResult<T> {

    private Integer code;
    private String msg;
    private T data;


    @Override
    public String toString() {
        return "AjaxResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AjaxResult() {
    }

    public AjaxResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxResult ok(){
        return new AjaxResult(200,"SUCCESS",null);
    }

    public static <T> AjaxResult<T> ok(T data){
        return new AjaxResult(200,"SUCCESS",data);
    }

}
