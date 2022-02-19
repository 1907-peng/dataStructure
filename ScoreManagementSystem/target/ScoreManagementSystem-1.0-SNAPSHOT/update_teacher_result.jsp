<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
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
    <title>修改学生成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
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
    try {
        String userName = ChangeEncoding(request.getParameter("user_name").trim());
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        String sql = "update teacher set " +
                "first_name='" + firstName + "'," +
                "last_name='" + lastName +
                "'" + "where user_name=" + "'" + userName + "'";

        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate(sql);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "向数据库修改老师信息数据" + "</font>");
        out.println("<P><font size=2'>" + "用户名为：" + userName + " 的老师数据信息已经被成功修改。" + "</font>");
%>
<p>
        <%
        out.print("</center>");
        JDBCUtils.close(conn,stmt);

    }
    catch(SQLException e)
    {
        out.print("错误");
        e.printStackTrace();
    }
%>
<center><a href="update_teacher.jsp" class="btn btn-info" role="button">返回</a></center>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="src/main/webapp/js/jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="src/main/webapp/bootstrap/css/bootstrap.min.css"></script>
</body>
</html>
