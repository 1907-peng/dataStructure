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
    <title>查找结果</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<%

    String id = request.getParameter("stuID");
    String sql = "select * from score where id='" + id + "'";//设置查询SQL语句

    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (!rs.next()) {
            out.print("<center>");
            out.println("<P><font size=2 color='blue'>" + "该学生尚未录入系统，请前去录入！" + "</font>");
%>
<center><a href="student_menu.jsp" class="btn btn-info" role="button">返回主页</a></center>
<%
} else {
%>


<center><h1>查询结果</h1></center>
<hr>
<form name="form1" method="post">
    <table class="table table-condensed table-hover">
        <tr>
            <td width="140" align="right">学号：</td>
            <td width="250" valign="top"><%=rs.getString("id")%>
            </td>
        </tr>
        <tr>
            <td width="140" align="right">姓名：</td>
            <td width="250" valign="top"><%=rs.getString("name")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right">电路成绩：</td>
            <td width="250" valign="top"><%=rs.getString("circuit_score")%>
            </td>
        </tr>
        <tr>
            <td width="140" align="right">英语读写：</td>
            <td width="250" valign="top"><%=rs.getString("en_RW_score")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right">大学物理：</td>
            <td width="250" valign="top"><%=rs.getString("physics_score")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right">近代史：</td>
            <td width="250" valign="top"><%=rs.getString("history_score")%>
            </td>
        </tr>


        <tr>
            <td width="140" align="right">总分：</td>
            <td width="250" valign="top"><%=rs.getString("total_score")%>
            </td>
        </tr>
        <tr>
            <td width="140" align="right">GPA：</td>
            <td width="250" valign="top"><%=rs.getString("gpa")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right"></td>
            <a href="student_menu.jsp" class="btn btn-info" role="button">返回</a>
        </tr>
    </table>
</form>
<%
        }
        JDBCUtils.close(conn, stmt, rs);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>
