<%@ page import="com.web.javaweb.student.javabean.entity.StudentDO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.javaweb.student.javabean.res.TableResult" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/9/9
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统页面</title>

<style>

    table {

        border-collapse: collapse;
        border-spacing: 0;
        border:1px solid black;
    }
    tr{
        line-height: 2;
    }
    th,td{
        border:1px solid black;
        padding:0 10px;
    }
    #cont{
        text-align: center;
        margin-top: 50px;
        line-height: 1.5;
    }
    .nav,.search,.page{
        line-height:2;
    }
</style>
</head>
<body>
    <div style="margin-top: 150px">
        <jsp:include page="../top.jsp"/>
        <div id="cont">
            <section class="nav">
                <a href="#">学生管理</a>
                <a href="#">成绩管理</a>
            </section>
            <section class="search">
                <a href="<%=request.getContextPath()%>/StudentServlet?type=toAdd">新增学生</a>
                <form method="post" action="">
                    <input type="text" name="studentName">
                    <input type="submit" value="查询">
                </form>
            </section>
            <section>
                <table style="margin-left: 600px">
                    <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>年级</th>
                            <th>宿舍号</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            TableResult<StudentDO> tableResult = (TableResult) request.getAttribute("tableResult");
                            List<StudentDO> data = tableResult.getData();
                            for (int i = 0; i < data.size(); i++) {
                                StudentDO studentDO = data.get(i);
                         %>

                            <tr>
                                <td><%= studentDO.getId() %></td>
                                <td><%= studentDO.getName() %></td>
                                <td><%= studentDO.getAge() %></td>
                                <td><%= studentDO.getGrade() %></td>
                                <td><%= studentDO.getDn() %></td>
                                <td>操作</td>
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                    <div class="page">
                        <a href="#">首页</a>
                        <a href="#">上一页</a>
                        <a href="#">下一页</a>
                        <a href="#">尾页</a>
                        <span>共XX页</span>
                        <span>共XX条</span>
                        <span>,当前是XX页</span>
                    </div>
                </table>
            </section>
        </div>
        <jsp:include page="../bottom.jsp"/>

    </div>
</body>
</html>
