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
<%!
    public double getSingleGPA(double a) {
        if (a < 60)
            return 0;
        else
            return (a - 60) / 10.0 + 1;
    }
%>
<%!
    public String getGPA(String circuitScore, String enRAndWScore, String physicsScore, String historyScore) {//处理中文字符串函数）
        double cirGrade = Double.parseDouble(circuitScore);
        double enRAndWGrade = Double.parseDouble(enRAndWScore);
        double physicsGrade = Double.parseDouble(physicsScore);
        double historyGrade = Double.parseDouble(historyScore);
        double all = getSingleGPA(cirGrade) * 3.5 + getSingleGPA(enRAndWGrade) * 4 + getSingleGPA(physicsGrade) * 2 + getSingleGPA(historyGrade) * 2;
        double ans = all / (11.5);
        return Double.toString(ans);
    }
%>
<%!
    public String getTotalScore(String circuitScore, String enRAndWScore, String physicsScore, String historyScore) {
        double cirGrade = Double.parseDouble(circuitScore);
        double enRAndWGrade = Double.parseDouble(enRAndWScore);
        double physicsGrade = Double.parseDouble(physicsScore);
        double historyGrade = Double.parseDouble(historyScore);
        double ans = cirGrade + enRAndWGrade + physicsGrade + historyGrade;
        return Double.toString(ans);
    }
%>
<%
    //接收客户端提交的数据
    try {
        String stuName = ChangeEncoding(request.getParameter("name").trim());
        String stuID = ChangeEncoding(request.getParameter("id").trim());
        String circuitScore = request.getParameter("circuit_score");
        String enRAndWScore = request.getParameter("en_RW_score");
        String physicsScore = request.getParameter("physics_score");
        String historyScore = request.getParameter("history_score");
        String rank = request.getParameter("rank");
        String gpa = getGPA(circuitScore, enRAndWScore, physicsScore, historyScore);
        String totalScore = getTotalScore(circuitScore, enRAndWScore, physicsScore, historyScore);


        String sql = "update score set " +
                "id='" + stuID + "'," +
                "name='" + stuName + "'," +
                "circuit_score='" + circuitScore + "'," +
                "en_RW_score  ='" + enRAndWScore + "'," +
                "physics_score='" + physicsScore + "'," +
                "history_score='" + historyScore + "'," +
                "total_score  ='" + totalScore + "'," +
                "gpa          ='" + gpa + "'," +
                "rank         ='" + rank + "'" +
                "where id='" + stuID + "'";

        Connection conn = JDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate(sql);
        out.print("<center>");
        out.println("<P><font size=2 color='blue'>" + "向数据库修改学生信息数据" + "</font>");
        out.println("<P><font size=2'>" + "学号为：" + stuID + " 的学生数据信息已经被成功修改。" + "</font>");
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
<center><a href="teacher_menu.jsp" class="btn btn-info" role="button">返回</a></center>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="src/main/webapp/js/jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="src/main/webapp/bootstrap/css/bootstrap.min.css"></script>
</body>
</html>
