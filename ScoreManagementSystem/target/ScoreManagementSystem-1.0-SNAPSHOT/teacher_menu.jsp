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
    <title>学生成绩管理老师管理界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<center><h1>学生成绩管理界面</h1></center>
<br>
<br><br><br><br><br><br>

<center>
    <div class="container">
        <ol class="nav nav-pills nav-justified">
            <li><a href="stu_Info_insert.jsp">增加学生成绩信息</a></li>
            <br>
            <li><a href="stu_info_delete.jsp">删除学生成绩信息</a></li>
            <br>
            <li><a href="choices_list.jsp">查找学生成绩信息</a></li>
            <br>
            <li><a href="Update1.jsp">修改学生成绩信息</a></li>
            <br>
            <li><a href="gpa_rank.jsp">按照学生GPA排名</a></li>
            <br>
            <li><a href="index.jsp">退出</a></li>
        </ol>
    </div>
</center>

<%@ include file="include_foot_JSP2.jsp" %>
<script src="jquery-3.2.1.min.js"></script>
<script src="bootstrap.min.js"></script>
</body>
</html>
