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

    #span{
        text-align: center;
        margin: 0px;
    }
</style>
<body>
    <div style="margin-top: 100px">
        <jsp:include page="top.jsp"/>
        <div id="cont" >
            <%
                String message = (String) request.getAttribute("message");
                if (message !=null){
            %>
            <h3 style="color:red;text-align:center;">出错信息:${{message}}</h3>
            <%
                }
            %>
            <form action="<%= request.getContextPath()%>/loginServlet?type=TrueLogin" method="post">
<%--            <form action="/StudentManagement">--%>
<%--                获取端口号   --%>
                <div id="span" style="padding: 0px">
                    <span style="color: #ff0000;display: none;">${message}</span>
                </div>
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
                    <input type="submit" onclick="errorDescript()" value="登录">
                    <input type="button" onclick="resetForm()" value="重置">
                </div>
            </form>
        </div>
        <jsp:include page="bottom.jsp"/>

    </div>
    <script>
        function resetForm() {
            document.forms[0].reset();
        }
    </script>
</body>
</html>
