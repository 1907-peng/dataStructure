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
    <title>修改老师信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<script language="javascript" type="">
    function checkform()
    {//验证输入数据的合法性
        if (form1.user_name.value=="") {
            alert("学号不能为空。");
            return false;
        }

        if (form1.user_password.value=="") {
            alert("密码不能为空。");
            return false;
        }


        if (form1.first_name.value=="") {
            alert("名字不能为空。");
            return false;
        }

        if (form1.last_name.value=="") {
            alert("姓名不能为空。");
            return false;
        }

    }


</script>
<body>
<%
    String userName = request.getParameter("user_name");
    String sql = "select * from teacher where user_name='" + userName + "'";

    try {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {//获取学生数据表中的记录
%>
<center><h3>修改成绩预览</h3></center>

<form class="m-t" role="form" name="form1" method=post action="update_teacher_result.jsp">
    <table class="table table-condensed table-hover">
        <tr>
            <td width="140" align="right">用户名：</td>
            <td width="250" valign="top"><%=rs.getString("user_name")%>
                <input type="hidden" name="user_name" value=<%=rs.getString("user_name")%> class="form-control"></td>
        </tr>
        <tr>
            <td width="140" align="right">密码：</td>
            <td width="250" valign="top"><%=rs.getString("user_password")%>
                <input type="hidden" name="user_password" value=<%=rs.getString("user_password")%> class="form-control">
            </td>
        </tr>
        <tr>
            <td width="140" align="right">名字：</td>
            <td>
                <input type="text" name="first_name" value=<%=rs.getString("first_name")%> class="form-control">
            </td>
        </tr>
        <tr>
            <td width="140" align="right">姓名：</td>
            <td><input type="text" name="last_name" value=<%=rs.getString("last_name")%> class="form-control"></td>
        </tr>

        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <button type="submit" class="btn btn-primary block full-width m-b"
                        onclick="javascript:return(checkform());">提交
                </button>

        </tr>
        <br>
        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <a href="admin_menu.jsp" class="btn btn-info" role="button">返回</a></td>
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