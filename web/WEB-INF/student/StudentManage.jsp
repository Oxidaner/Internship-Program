<%@ page import="com.web.javaweb.student.javabean.entity.StudentDO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.javaweb.student.javabean.res.TableResult" %>
<%@ page import="com.mysql.cj.log.Log" %>
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
        text-align: center;
        margin-top: 20px;
        line-height: 1.5;
    }
    .nav,.search,.page{
        line-height:2;
    }
</style>
</head>
<body>
    <div style="margin-top: 100px">
        <jsp:include page="../top.jsp"/>
        <div id="cont">
            <section class="nav">
                <a href="#">学生管理</a>
                <a href="#">成绩管理</a>
            </section>
            <section class="search">
                <%
                    TableResult<StudentDO> tableResult = (TableResult) request.getAttribute("tableResult");
                %>
                <a href="<%=request.getContextPath()%>/StudentServlet?type=toAdd">新增学生</a>
                <form method="post" action="<%=request.getContextPath()%>/StudentServlet?type=toStudentManage">
                    <input type="text" name="studentName" value="<%= tableResult.getStudentName() %>">
                    <%--
                    value在没有被别人修改得时候就是1
                    由于不是ajax局部刷新,页面是整体刷新的,所以即便pageNow被修改了,查询结果出来的页面中的pageNow仍然还是1
                    --%>
                    <input type="hidden" name="pageNow" id="pageNow" value="1">
                    <input type="submit" value="查询">
                </form>
            </section>
            <section>
                <table style="margin-left:auto; margin-right:auto; margin-top: 10px">
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
                                <td>
                                    <a href="<%=request.getContextPath()%>/StudentServlet?type=delete&id=<%= studentDO.getId() %>">删除</a>
                                    <a href="<%=request.getContextPath()%>/StudentServlet?type=toUpdate&id=<%= studentDO.getId() %>&pageNow=<%= tableResult.getPageNow() %>">更新</a>
                                </td>
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <div class="page">
                    <%
                        //只要不是第一页就显示
                        if (tableResult.getPageNow() > 1){
                    %>
                    <a href="#" onclick="goFirst()">首页</a>
                    <a href="#" onclick="goPre()">上一页</a>
                    <%
                        }
                    %>
                    <%
                        //只需要不是最后一页就显示
                        if (tableResult.getPageNow() != tableResult.getPageCount()){
                    %>
                    <a href="#" onclick="goNext()">下一页</a>
                    <a href="#" onclick="goLast()">尾页</a>
                    <%
                        }
                    %>
                    <span>共<%= tableResult.getPageCount() %>页</span>
                    <span>共<%= tableResult.getTotalCount() %>条</span>
                    <span>,当前是<%= tableResult.getPageNow() %>页</span>
                </div>

            </section>
        </div>
        <jsp:include page="../bottom.jsp"/>

    </div>
    <script>
        // 首页
        function goFirst(){
            document.forms[0].submit();
        }
        // 上一页
        function goPre() {
            //1.拿到当前页
            var currentPageStr = "<%= tableResult.getPageNow() %>";
            var prePage = parseInt(currentPageStr) - 1;
            //2.修改搜索里面提交的pageNow
            document.getElementById("pageNow").value = prePage;
            document.forms[0].submit();
        }
        //下一页
        function goNext() {
            //1.拿到当前页
            var currentPageStr = "<%= tableResult.getPageNow() %>";
            var nextPage = parseInt(currentPageStr) + 1;
            //2.修改搜索里面提交的pageNow
            document.getElementById("pageNow").value = nextPage;
            document.forms[0].submit();

        }
        //尾页
        function goLast() {
            //1.拿到尾页
            var PageCountStr = "<%= tableResult.getPageCount() %>"
            document.getElementById("pageNow").value = parseInt(PageCountStr);
            document.forms[0].submit();
        }
    </script>
</body>
</html>
