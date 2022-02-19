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
    <title>删除学生成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<%

    String sql = "select * from score";//设置查询SQL语句

    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
%>
<center><h1>学生成绩一览表</h1></center>
<hr>
<table class="table table-condensed table-hover">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>电路成绩</th>
        <th>英语读写</th>
        <th>大学物理</th>
        <th>近代史</th>
        <th>总分</th>
        <th>GPA</th>
        <th>删除</th>
    </tr>
    </thead>
    <%
        while (rs.next()) {//获取学生数据表中的记录
    %>
    <tr>
        <td><%=rs.getString("id")%>
        </td>
        <td><%=rs.getString("name")%>
        </td>
        <td><%=rs.getString("circuit_score")%>
        </td>
        <td><%=rs.getString("en_RW_score")%>
        </td>
        <td><%=rs.getString("physics_score")%>
        </td>
        <td><%=rs.getString("history_score")%>
        </td>
        <td><%=rs.getString("total_score")%>
        </td>
        <td><%=rs.getString("gpa")%>
        </td>

        <td><a href="decide_delete.jsp?id=<%=rs.getObject(1)%>">删除</a></td>
    </tr>
    <%
            }
            JDBCUtils.close(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
<center><a href="teacher_menu.jsp" class="btn btn-info" role="button">返回</a></center>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>