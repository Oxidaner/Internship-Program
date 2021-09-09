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
    <title>学生管理系统登录页面</title>
</head>
<style>
    #cont div {
        text-align: center;
        padding: 15px;
        margin-left: 0;
        margin-right: 0;
    }
    #btns input:first-child{
        margin-right: 30px;
    }
    #btns input:last-child{
        margin-left: 30px;
    }
</style>
<body background="<%= request.getContextPath()%>/resources/img/src=http___cdn.52ppt.com_d_file_beijing_201412_2014121510573002.jpg&refer=http___cdn.52ppt.jpg">
    <div style="margin-top: 150px">
        <jsp:include page="top.jsp"/>
        <div id="cont" >
            <form action="<%= request.getContextPath()%>/loginServlet?type=TrueLogin" method="post">
<%--            <form action="/StudentManagement">--%>
<%--                获取端口号   --%>
                <div>
                    <lable for="userName" >
                       用户名:
                    </lable>
                   <input type="text" name="userName" id="userName"/>
                </div>
                <div>
                    <lable>
                       &nbsp;&nbsp;&nbsp;密码:
                       <input type="password" name="pwd"/>
                    </lable>
                </div>
                <div id="btns">
                    <input type="submit" value="登录">
                    <input type="button" value="重置">
                </div>
            </form>
        </div>
        <jsp:include page="bottom.jsp"/>

    </div>
</body>
</html>
