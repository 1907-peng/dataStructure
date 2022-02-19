<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background: url("img/back.jpg") no-repeat center 0px;
            background-size: 100% 100%;
        }
    </style>
    <title>增加学生成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<%!
    public double getsinglegpa(double a) {
        if (a < 60)
            return 0;
        else
            return (a - 60) / 10.0 + 1;
    }
%>
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
    public String getGPA(String circuitScore, String enRAndWScore, String physicsScore, String historyScore) {//处理中文字符串函数）
        double cirGrade = Double.parseDouble(circuitScore);
        double enRAndWGrade = Double.parseDouble(enRAndWScore);
        double physicsGrade = Double.parseDouble(physicsScore);
        double historyGrade = Double.parseDouble(historyScore);
        double all = getsinglegpa(cirGrade) * 3.5 + getsinglegpa(enRAndWGrade) * 4 + getsinglegpa(physicsGrade) * 2 + getsinglegpa(historyGrade) * 2;
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
    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC";
    String USER = "root";
    String PASSWORD = "123456";
    //接收客户端提交的数据
    String stuID = ChangeEncoding(request.getParameter("id").trim());
    String stuName = ChangeEncoding(request.getParameter("name").trim());
    String circuitScore = request.getParameter("circuitScore");
    String enRAndWScore = request.getParameter("enRAndWScore");
    String physicsScore = request.getParameter("physicsScore");
    String historyScore = request.getParameter("historyScore");
    String rank = request.getParameter("rank");

    String totalScore = getTotalScore(circuitScore, enRAndWScore, physicsScore, historyScore);
    String gpa = getGPA(circuitScore, enRAndWScore, physicsScore, historyScore);
    //构造SQL语句
    String sql = "insert into score(id,name,circuit_score,en_RW_score,physics_score,history_score,total_score,gpa,rank)" +
            "VALUES('" +
            stuID + "','" + stuName + "','" + circuitScore + "','" +
            enRAndWScore + "','" + physicsScore + "','" + historyScore + "','" +
            totalScore + "','" + gpa + "','" + rank +
            "')";

    try {
        Class.forName(DRIVER).newInstance();
    } catch (ClassNotFoundException e) {
        out.print("错误");
        e.printStackTrace();
    }
    try {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        out.print("<center>");
        out.println("<P><font size=2'>" + "向数据库增加学生信息" + "</font>");
        out.println("<P><font size=2'>" + "该学生信息数据已经成功添加到数据库。" + "</font>");
%>
<p>
<center><a href="teacher_menu.jsp" class="btn btn-info" role="button">返回</a></center>
<%
        out.print("</center>");
        stmt.close();
        conn.close();

    } catch (SQLException e) {
        out.print("错误");
        e.printStackTrace();
    }
%>
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>