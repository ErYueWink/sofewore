package com.xiaoxiao.exception;

import com.alibaba.fastjson.JSON;
import com.xiaoxiao.result.AjaxResult;
import com.xiaoxiao.util.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void defaultGlobalExceptionHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws IOException {
        e.printStackTrace();
        AjaxResult ajaxResult = new AjaxResult(CodeEnum.SYSTEM_ERROR.getCode(), CodeEnum.SYSTEM_ERROR.getMsg(), null);
        response.getWriter().write(JSON.toJSONString(ajaxResult));
    }

    @ExceptionHandler(BusException.class)
    public void defaultExceptionHandler(HttpServletRequest request,HttpServletResponse response,BusException e) throws IOException {
        AjaxResult ajaxResult = new AjaxResult(e.getCode(),e.getMsg(),null);
        response.getWriter().write(JSON.toJSONString(ajaxResult));

    }

}
