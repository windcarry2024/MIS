package com.hys.mis.filter;

import com.alibaba.fastjson.JSONObject;
import com.hys.mis.pojo.Result;
import com.hys.mis.utils.JWTUtils;
import com.hys.mis.utils.StorageUtils;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();

        if(url.contains("login"))
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else
        {
            String token = req.getHeader("token");
            if(JWTUtils.verifyJWT(token))
            {
                StorageUtils.token = token;
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else
            {
                Result result = Result.generate(400,"token为空或登录已过期");
                String error = JSONObject.toJSONString(result);
                resp.setContentType("application/json; charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(error);
            }
        }
    }

}
