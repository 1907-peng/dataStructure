<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" %>
<%@ page import="com.google.util.JDBCUtils" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background: url("img/back.jpg") no-repeat center 0px;
            background-size: 100% 100%;
        }
    </style>
    <title>增加学生成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>

<%!
    public String ChangeEncoding(String str) {//编码转换（处理中文字符串函数）
        String s = str;
        try {
            byte tempB[] = s.getBytes("ISO-8859-1");
            s = new String(tempB);
            return s;
        } catch (Exception e) {
            System.out.print("数据类型转换出错！" + e.toString());
            return s;
        }
    }
%>


<%
    //接收客户端提交的数据
    String user_name = ChangeEncoding(request.getParameter("userName").trim());
    String user_password = ChangeEncoding(request.getParameter("userPassword").trim());
    String first_name = request.getParameter("firstName");
    String last_name = request.getParameter("lastName");

    //构造SQL语句
    String sql = "insert into teacher(user_name,user_password,first_name,last_name)" +
            "VALUES('" +
            user_name + "','" + user_password + "','" + first_name + "','" + last_name +
            "')";


    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate(sql);
        out.print("<center>");
        out.println("<P><font size=2'>" + "向数据库增加老师信息" + "</font>");
        out.println("<P><font size=2'>" + "该老师信息数据已经成功添加到数据库。" + "</font>");
%>
<p>
<center><a href="admin_menu.jsp" class="btn btn-info" role="button">返回</a></center>
<%
        out.print("</center>");
        JDBCUtils.close(conn, stmt);

    } catch (SQLException e) {
        out.print("错误");
        e.printStackTrace();
    }
%>
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>