package com.xiaoxiao.security;

import com.alibaba.fastjson.JSON;
import com.xiaoxiao.result.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        AjaxResult ajaxResult = new AjaxResult(402, "用户名或密码错误", null);
        response.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}
