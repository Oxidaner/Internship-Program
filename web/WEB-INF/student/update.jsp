<%@ page import="com.web.javaweb.student.javabean.entity.StudentDO" %><%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/9/9
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生页面</title>
</head>
<style>
    #cont{
        text-align: center;
        margin-top: 30px;
    }
    #cont div{
        width:100%;
        padding:15px;
        float: left;
    }
</style>
<body>
    <div style="margin-top: 100px">
        <jsp:include page="../top.jsp"/>
        <div id="cont" >
            <form action="<%= request.getContextPath()%>/StudentServlet?type=update&pageNow=${requestScope.pageNow}" method="post">
                <%
                    StudentDO studentDO = (StudentDO) request.getAttribute("studentDO");
                %>
                <div>
                    <lable for="userName" >
                        &nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;
                        <%--pagescope req session application--%>
                        <input type="text" name="name" value="${studentDO.name}"/>
                    </lable>
                </div>
                <div>
                    <lable>
                       &nbsp;&nbsp;&nbsp;学号:&nbsp;&nbsp;
                        <%--disable不会传参 readOnly可以提交 并且被调用传参--%>
                       <input type="text"  readOnly name="id" value="${studentDO.id}"/>
                    </lable>
                </div>
                <div>
                    <lable>
                        &nbsp;&nbsp;&nbsp;年龄:&nbsp;&nbsp;
                        <input type="text" name="age" value="${studentDO.age}"/>
                    </lable>
                </div>
                <div>
                    <lable>
                        &nbsp;&nbsp;&nbsp;年级:&nbsp;&nbsp;
                        <input type="text" name="grade" value="${studentDO.grade}"/>
                    </lable>
                </div>
                <div>
                    <lable>
                        宿舍号:&nbsp;&nbsp;
                        <input type="text" name="dn" value="${studentDO.dn}"/>
                    </lable>
                </div>

                <div id="btns">
                    <input type="submit" value="更新">
                </div>
            </form>
        </div>
        <jsp:include page="../bottom.jsp"/>

    </div>

</body>
</html>
