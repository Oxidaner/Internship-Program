package com.web.javaweb.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/9 - 09 - 09 - 18:52
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if("TrueLogin".equals(type)){
            /*执行登录的*/

        }else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }

    }
}
