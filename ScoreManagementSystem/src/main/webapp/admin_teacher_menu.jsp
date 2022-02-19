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
            <li><a href="teacher_info_insert.jsp">增加老师信息</a></li>
            <br>
            <li><a href="teacher_info_delete.jsp">删除老师信息</a></li>
            <br>
            <li><a href="find_teacher_via_user_name.jsp">查找老师信息</a></li>
            <br>
            <li><a href="update_teacher.jsp">修改老师信息</a></li>
            <br>
            <li><a href="index.jsp">退出</a></li>
        </ol>
    </div>
</center>

<%@ include file="include_foot_JSP2.jsp" %>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>
