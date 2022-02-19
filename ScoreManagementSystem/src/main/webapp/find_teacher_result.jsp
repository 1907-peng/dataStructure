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
    String userName = request.getParameter("user_name");

    String sql = null;
    if (userName != null) {
        sql = "select * from teacher where user_name='" + userName + "'";
    }

    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (!rs.next()) {
            out.print("<center>");
            out.println("<P><font size=2 color='blue'>" + "该老师尚未录入系统，请前去录入！" + "</font>");
%>
<center><a href="admin_menu.jsp" class="btn btn-info" role="button">返回主页</a></center>
<%
} else {
%>
<center><h1>查询结果</h1></center>
<%
    do {
%>


<hr>
<form name="form1" method="post">
    <table class="table table-condensed table-hover">
        <tr>
            <td width="140" align="right">用户名：</td>
            <td width="250" valign="top"><%=rs.getString("user_name")%>
            </td>
        </tr>
        <tr>
            <td width="140" align="right">密码：</td>
            <td width="250" valign="top"><%=rs.getString("user_password")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right">名字：</td>
            <td width="250" valign="top"><%=rs.getString("first_name")%>
            </td>
        </tr>
        <tr>
            <td width="140" align="right">姓：</td>
            <td width="250" valign="top"><%=rs.getString("last_name")%>
            </td>
        </tr>


        <tr>
            <td width="140" align="right"></td>
            <a href="admin_menu.jsp" class="btn btn-info" role="button">返回</a>
        </tr>
    </table>
</form>
<%
            } while (rs.next());
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
