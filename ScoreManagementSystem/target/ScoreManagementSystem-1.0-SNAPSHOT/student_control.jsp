<%--
  Created by IntelliJ IDEA.
  User: Mr.Peng
  Date: 2017/6/21
  Time: 02:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" %>
<%@ page import="com.google.util.JDBCUtils" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>学生登陆处理页面</title>
</head>
<body>
<%
    String paraStuID = request.getParameter("stuID");
    String paraPassword = request.getParameter("stuPassword");

    if (paraStuID == null || paraPassword == null) {
        out.println("<P><font size=2 color='blue'>" + "请先登录" + "</font>");
%>

<td width="100" align="center" class="style4"><a href="student_login.jsp">返回登录界面</a></td>

<%
} else {

    if (isExistInDB(paraStuID, paraPassword)) {
        session.setAttribute("isStudent", true);
        request.getRequestDispatcher("student_menu.jsp").forward(request, response);
    } else {
        session.setAttribute("isStudent", false);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "用户名或密码错误" + "</font>");
%>

<td width="100" align="center" class="style4"><a href="student_login.jsp">返回主页</a></td>

<%
        }
    }
%>

<%!
    private boolean isExistInDB(String paraID, String paraPassword) {
        String sql = "select id , rank from score";
        HashMap<String, String> stuInfoMap = new HashMap<>();

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                stuInfoMap.put(rs.getString("id"), rs.getString("rank"));
            }
            for (Map.Entry<String, String> entry : stuInfoMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (paraPassword.equals(stuInfoMap.get(paraID))) return true;
        return false;
    }
%>

</body>
</html>
