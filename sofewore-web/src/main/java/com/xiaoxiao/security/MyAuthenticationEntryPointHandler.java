package com.xiaoxiao.security;

import com.alibaba.fastjson.JSON;
import com.xiaoxiao.result.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        AjaxResult ajaxResult = new AjaxResult(401, "用户未登录", null);
        response.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}
