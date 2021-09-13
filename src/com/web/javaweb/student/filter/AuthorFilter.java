package com.web.javaweb.student.filter;

import com.web.javaweb.student.javabean.entity.AdminDO;
import com.web.javaweb.student.util.Constants;
import com.web.javaweb.student.util.ExcludeResourceUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/12 - 09 - 12 - 9:40
 * @Description: com.web.javaweb.student.filter
 * @version: 1.0
 */

/*
* 授权管理
* */
@WebFilter(filterName = "authorFilter",urlPatterns = {"/*"}/*拦截数组*/
)

public class AuthorFilter implements Filter{
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //过滤静态资源
        String requestURI = httpServletRequest.getRequestURI();
        /*如果应该排除就放行
         * 如果不应该排除就设置字符编码*/
        if (ExcludeResourceUtil.shouldExclude(requestURI)) {
            chain.doFilter(req, resp);//放行
        }else{
            HttpSession session = httpServletRequest.getSession();
            AdminDO admin = (AdminDO) session.getAttribute("admin");
            String contextPath = httpServletRequest.getContextPath();
            String path = requestURI.substring(contextPath.length());
            if (admin == null){
                if("/loginServlet".equals(path)){
                    chain.doFilter(req, resp);
                }else { //未登录且访问的路径不是公共路径
                    httpServletRequest.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
                }
            }else{
                chain.doFilter(req, resp);
            }
        }

    }


}
