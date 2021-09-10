package com.web.javaweb.student.servlet;

import com.web.javaweb.student.dao.AdminDao;
import com.web.javaweb.student.javabean.entity.AdminDO;
import com.web.javaweb.student.service.AdminService;
import com.web.javaweb.student.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
// 扩展 HttpServlet 类
public class LoginServlet extends HttpServlet {
    @Override
    /*处理post请求*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    /*GET 请求来自于一个 URL 的正常请求，或者来自于一个未指定 METHOD 的 HTML 表单，它由 doGet() 方法处理。*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        /*您可以调用 request.getParameter() 方法来获取表单参数的值。*/
        if("TrueLogin".equals(type)){
            /*执行登录的页面*/
            String userName = request.getParameter("userName");
            String pwd = request.getParameter("pwd");
            if (userName == null||"".equals(userName.trim())|| pwd == null || "".equals(pwd.trim())){
                request.setAttribute("message","用户名或密码不能为空");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
                return;
            }
            AdminService adminService = new AdminServiceImpl();
            AdminDO adminDO = adminService.validateLogin(userName);
            if (adminDO != null && pwd.equals(adminDO.getPwd())){
                //放到session之前清空密码
                adminDO.setPwd(null);
                request.getSession().setAttribute("admin",adminDO);
                //当我们做了提交表单的动作后在通过getRequestDispatcher进行内部转发（内部转发可以访问WEB-INF下面的页面）,
                //刷新页面会导致表单的重复提交,地址产生变化,但是重定向就不会
                System.out.println("密码正确,跳转到主页面");
                response.sendRedirect( request.getContextPath() + "/StudentServlet?type=toStudentManage");
//                重定向
            }else {
                //密码不正确,回到登录页面
                request.setAttribute("message","用户名或密码不正确");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
            }
        }else {
            /*跳转到login*/
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }

    }
}
