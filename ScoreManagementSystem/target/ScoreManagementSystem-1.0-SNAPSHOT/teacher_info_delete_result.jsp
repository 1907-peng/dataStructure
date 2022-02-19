<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
<%@ page import="com.google.util.JDBCUtils" %>
<%@ page import="java.util.Enumeration" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background: url("img/back.jpg") no-repeat center 0px;
            background-size: 100% 100%;
        }
    </style>
    <title>删除老师成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap.css" rel="stylesheet">
</head>
<%!
    public String codeToString(String str) {//编码转换（处理中文字符串函数）
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

    String user_name = request.getParameter("user_name");
    Enumeration enumeration = request.getParameterNames();
    while (enumeration.hasMoreElements()) {
        System.out.println(enumeration.nextElement());
    }
    String sql = "delete from teacher where user_name='" + user_name + "'";


    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate(sql);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "向数据库删除老师信息数据" + "</font>");
        out.println("<P><font size=2'>" + "用户名为：" + user_name + " 的老师数据信息已经被成功删除。" + "</font>");
%>
<p>

        <%

        out.print("</center>");
        JDBCUtils.close(conn, stmt);


    }
    catch(SQLException e)
    {
        out.print("错误");
        e.printStackTrace();
    }
%>
<center><a href="admin_menu.jsp" class="btn btn-info" role="button">返回</a></center>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>