package com.web.javaweb.student.servlet;

import com.web.javaweb.student.javabean.entity.StudentDO;
import com.web.javaweb.student.javabean.req.StudentRequest;
import com.web.javaweb.student.javabean.res.TableResult;
import com.web.javaweb.student.service.StudentService;
import com.web.javaweb.student.service.impl.StudentServiceImpl;

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
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("toStudentManage".equals(type)) {
            //查询出来的学生放入request中
            String studentName = request.getParameter("studentName");
            String pageNowStr = request.getParameter("pageNow");//当前第几页
            StudentRequest studentRequest = new StudentRequest();
            int pageNow = 1; //默认差第一页
            if (pageNowStr != null && !"".equals(pageNowStr.trim())) {
                pageNow = Integer.parseInt(pageNowStr);
            }
            studentRequest.setPageNow(pageNow);
            studentRequest.setStudentName(studentName);
            studentService.queryStudentByPage(studentRequest);
            TableResult<StudentDO> tableResult =studentService.queryStudentByPage(studentRequest);
            tableResult.setPageNow(pageNow);
            tableResult.setStudentName(studentName);
            //放到request请求里面去,并在studentManage.jsp中使用
            request.setAttribute("tableResult",tableResult);
            request.getRequestDispatcher("/WEB-INF/student/StudentManage.jsp").forward(request, response);
        } else if ("toAdd".equals(type)) {
            System.out.println("toadd");
            request.getRequestDispatcher("/WEB-INF/student/Add.jsp").forward(request, response);
        } else if ("add".equals(type)) {
            //执行添加
            String studentName = request.getParameter("studentName");
            String id = request.getParameter("id");
            String age = request.getParameter("age");
            String grade = request.getParameter("grade");
            String dn = request.getParameter("dn");
            StudentDO studentDO = new StudentDO();
            studentDO.setName(studentName);
            studentDO.setId(id);
            studentDO.setAge(age);
            studentDO.setDn(dn);
            studentDO.setGrade(grade);
            studentService.addStudent(studentDO);
            response.sendRedirect( request.getContextPath() + "/StudentServlet?type=toStudentManage");
        }else if ("toUpdate".equals(type)) {
            //查找要更新的对象,再回想到页面上
            String studentID = request.getParameter("id");
            String pageNow = request.getParameter("pageNow");
            StudentDO studentDO = studentService.getStudentById(Integer.parseInt(studentID));
            request.setAttribute("studentDO",studentDO);
            request.setAttribute("pageNow",Integer.parseInt(pageNow));
            request.getRequestDispatcher("/WEB-INF/student/update.jsp").forward(request, response);
        }else if ("update".equals(type)) {
            //查找要更新的对象,再回想到页面上
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String grade = request.getParameter("grade");
            String dn = request.getParameter("dn");
            String pageNow = request.getParameter("pageNow");
            //把参数封装为对象
            StudentDO studentDO = new StudentDO();
            studentDO.setName(name);
            studentDO.setId(id);
            studentDO.setAge(age);
            studentDO.setDn(dn);
            studentDO.setGrade(grade);
            studentService.updateStudent(studentDO);
            request.setAttribute("studentDO",studentDO);
            response.sendRedirect( request.getContextPath() + "/StudentServlet?type=toStudentManage&pageNow="+pageNow);
        }else if ("delete".equals(type)) {
            //查找要更新的对象,再回想到页面上
            String id = request.getParameter("id");
            studentService.deleteStudentById(Integer.parseInt(id));
            response.sendRedirect( request.getContextPath() + "/StudentServlet?type=toStudentManage");
        }
    }
}