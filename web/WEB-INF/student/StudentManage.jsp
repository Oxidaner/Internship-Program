<%--
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
        text-align: left;
        margin-left: 560px;
        margin-top: 50px;
        line-height: 1.5;
    }
    .nav,.search,.page{
        line-height:2;
    }
</style>
</head>
<body background="<%= request.getContextPath()%>/resources/img/src=http___cdn.52ppt.com_d_file_beijing_201412_2014121510573002.jpg&refer=http___cdn.52ppt.jpg">
    <div style="margin-top: 150px">
        <jsp:include page="../top.jsp"/>
        <div id="cont">
            <section class="nav">
                <a href="#">学生管理</a>
                <a href="#">成绩管理</a>
            </section>
            <section class="search">
                <a href="#">新增学生</a>
                <form method="post" action="">
                    <input type="text" name="studentName">
                    <input type="submit" value="查询">
                </form>
            </section>
            <section>
                <table>
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
