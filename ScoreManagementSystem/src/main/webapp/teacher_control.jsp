<%@ page import="java.sql.Connection" %>
<%@ page import="com.google.util.JDBCUtils" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>老师登陆处理页面</title>
</head>
<body>
<%
    String paraName = request.getParameter("teacherName");
    String paraPassword = request.getParameter("teacherPassword");

    if (paraName == null || paraPassword == null) {
        out.println("<P><font size=2 color='blue'>" + "请先登录" + "</font>");
%>

<td width="100" align="center" class="style4"><a href="teacher_login.jsp">返回登录界面</a></td>

<%
} else {

    if (isExistInDB(paraName, paraPassword)) {
        session.setAttribute("isTeacher", true);
        request.getRequestDispatcher("teacher_menu.jsp").forward(request, response);
    } else {
        session.setAttribute("isTeacher", false);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "老师用户或密码错误" + "</font>");
%>

<td width="100" align="center" class="style4"><a href="teacher_login.jsp">返回主页</a></td>

<%
        }
    }
%>
<%!
    private boolean isExistInDB(String paraName, String paraPassword) {
        String sql = "select user_name , user_password from teacher";
        HashMap<String, String> teacherInfoMap = new HashMap<>();

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                //将teacher表中所有的用户名和密码放在Hash表中
                teacherInfoMap.put(rs.getString("user_name"), rs.getString("user_password"));
            }
            for (Map.Entry<String, String> entry : teacherInfoMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (paraPassword.equals(teacherInfoMap.get(paraName))) return true;
        return false;
    }
%>
</body>
</html>
