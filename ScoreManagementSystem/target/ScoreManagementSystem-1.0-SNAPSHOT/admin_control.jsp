<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background: url("img/back.jpg") no-repeat center 0px;
            background-size: 100% 100%;
        }
    </style>
    <title>管理员登陆处理页面</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<%
    String name = request.getParameter("adminName");
    String password = request.getParameter("adminPassword");

    if (name == null || password == null) {
        out.println("<P><font size=2 color='blue'>" + "请先登录" + "</font>");
%>
<td width="100" align="center" class="style4"><a href="admin_login.jsp">返回登录界面</a></td>
<%
} else {

    if (name.equals("admin") && password.equals("123456")) {
        session.setAttribute("isAdmin", true);
        request.getRequestDispatcher("admin_menu.jsp").forward(request, response);

    } else {
        session.setAttribute("isAdmin", false);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "管理员用户或密码错误" + "</font>");
%>
<td width="100" align="center" class="style4"><a href="admin_login.jsp">返回主页</a></td>
<%
        }
    }
%>

<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>
