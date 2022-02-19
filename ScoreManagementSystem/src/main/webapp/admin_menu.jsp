<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background: url("img/back.jpg") no-repeat center 0px;
            background-size: 100% 100%;
        }
    </style>
    <title>学生成绩管理管理员界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<center><h1>学生成绩管理系统管理员界面</h1></center>
<br>
<br><br><br><br><br><br>

<center>
    <div class="container">
        <ol class="nav nav-pills nav-justified">
            <li><a href="admin_teacher_menu.jsp">处理老师信息</a></li>
            <br>
            <li><a href="admin_student_menu.jsp">处理学生信息</a></li>
            <br>
            <li><a href="index.jsp">退出</a></li>
        </ol>
    </div>
</center>
<footer>
    <br>
    <hr>
    <p>
    <table width="50%" border="0" align="center">
        <tr class="style1" bgcolor="#CCFF22" align="center">
            <td width="15%" align="center">版权所有 Copyright@2021-2050</td>
        </tr>
        <tr class="style1" bgcolor="#CCFF22" align="center">
            <td width="15%">Mr.Peng</td>
        </tr>
        <tr class="style1" bgcolor="#CCFF22" align="center">
            <td width="15%">联系方式：xxx</td>
        </tr>
    </table>
</footer>
<%--<%@ include file="include_foot_JSP2.jsp" %>--%>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>
