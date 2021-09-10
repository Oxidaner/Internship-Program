package com.web.javaweb.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhangshibin
 * @Date: 2021/9/10 - 09 - 10 - 23:55
 * @Description: ${PACKAGE_NAME}
 * @version: 1.0
 */
@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String type = request.getParameter("type");
       if ("toStudentManage".equals(type)){
           request.getRequestDispatcher("/WEB-INF/student/StudentManage.jsp").forward(request,response);
       }
    }
}
