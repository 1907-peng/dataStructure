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
    <title>选择查询方式</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<center><h1>学生成绩管理系统学生界面</h1></center>
<br>
<br><br><br><br><br><br>

<center>
    <div class="container">
        <ol class="nav nav-pills nav-justified">

            <li><a href="teacher_find_student_via_id.jsp">按照学号查找</a></li><br>
            <li><a href="teacher_find_student_via_name.jsp">按照姓名查找</a></li><br>
            <li><a href="teacher_find_student_via_fuzzy_search.jsp">模糊查找</a></li><br>

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
