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
    <title>删除学生成绩信息预览</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<%

    String id = request.getParameter("id");
    String sql = "select * from score where id='" + id + "'";//设置查询SQL语句

    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {//获取学生数据表中的记录
%>
<div align=center class="style2">删除学生信息预览</div>
<br>
<hr>
<form name="form1" method="post" action="stu_info_delete_result.jsp">
    <table class="table table-condensed table-hover">
        <tr>
            <td width="140" align="right">学号：</td>
            <td width="250" valign="top"><%=rs.getString("id")%>
                <input type="hidden" name="id" value=<%=rs.getString("id")%> class="style1"></td>
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
            <td width="250" valign="top" class="style1"><%=rs.getString("total_score")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right">GPA：</td>
            <td width="250" valign="top" class="style1"><%=rs.getString("gpa")%>
            </td>
        </tr>

        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <input type="submit" name="Submit" value="提交" class="btn btn-primary block full-width m-b"></td>
        </tr>

        <br>
        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <a href="teacher_menu.jsp" class="btn btn-info" role="button">返回</a></td>
            >
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


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>