package com.xiaoxiao.security;

import com.alibaba.fastjson.JSON;
import com.xiaoxiao.result.AjaxResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        AjaxResult ajaxResult = new AjaxResult(200, "退出成功", null);
        response.getWriter().write(JSON.toJSONString(ajaxResult));
    }
}
