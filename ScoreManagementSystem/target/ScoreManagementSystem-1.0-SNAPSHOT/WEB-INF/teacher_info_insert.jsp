<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-image: url("img/background.jpg");
        }
    </style>
    <title>增加学生成绩信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="bootstrap.css" rel="stylesheet">
</head>
<script language="javascript" type="">
    function checkform()
    {//验证输入数据的合法性
        if (form1.id.value=="") {
            alert("学号不能为空。");
            return false;
        }
        if (isNaN(form1.id.value)) {
            alert("学号只能为数字");
            return false;
        }
        if (form1.name.value=="") {
            alert("姓名不能为空。");
            return false;
        }

        if (form1.circuitScore.value=="") {
            alert("电路成绩不能为空。");
            return false;
        }
        if (isNaN(form1.circuitScore.value))
        {
            alert("电路成绩只能为数字");
            return false;
        }
        else
        {
            var num=parseFloat(form1.circuitScore.value);
            if (num<0||num>100)
            {
                alert("电路成绩必须在0-100之间！");
                return false;
            }
        }
        if (form1.enRAndWScore.value=="") {
            alert("英语读写成绩不能为空。");
            return false;
        }
        if (isNaN(form1.enRAndWScore.value))
        {
            alert("英语读写成绩只能为数字");
            return false;
        }
        else
        {
            var num=parseFloat(form1.enRAndWScore.value);
            if (num<0||num>100)
            {
                alert("英语读写成绩必须在0-100之间！");
                return false;
            }
        }

        if (form1.physicsScore.value=="") {
            alert("大学物理成绩不能为空。");
            return false;
        }
        if (isNaN(form1.physicsScore.value))
        {
            alert("大学物理成绩只能为数字");
            return false;
        }
        else
        {
            var num=parseFloat(form1.physicsScore.value);
            if (num<0||num>100)
            {
                alert("大学物理成绩必须在0-100之间！");
                return false;
            }
        }

        if (form1.historyScore.value=="") {
            alert("近代史成绩不能为空。");
            return false;
        }
        if (isNaN(form1.historyScore.value))
        {
            alert("近代史成绩只能为数字");
            return false;
        }
        else
        {
            var num=parseFloat(form1.historyScore.value);
            if (num<0||num>100)
            {
                alert("近代史成绩必须在0-100之间！");
                return false;
            }
        }

        if (form1.rank.value=="") {
            alert("查询密码成绩不能为空。");
            return false;
        }
        if (form1.rank.value.length<1||form1.rank.value.length>20) {
            alert("密码超出了范围（1～20）");
            return false;
        }
    }





</script>
<body>
<div align=center class="style2">增加老师信息</div>
<hr>
<form name="form1" method="post" action="teacher_info_insert_result.jsp">
    <table width="400" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
        <tr>
            <td width="140" align="right">用户名：</td>
            <td width="250" valign="top">
                <input type="text" name="userName" size="16" maxlength="25">
            </td>
        </tr>

        <tr>
            <td width="140" align="right">登录密码：</td>
            <td width="250" valign="top">
                <p><input type="text" name="userPassword" maxlength="20" size="16">
            </td>
        </tr>

        <tr>
            <td width="140" align="right">名字：</td>
            <td width="250" valign="top">
                <p><input type="text" name="firstName" maxlength="20" size="16">
            </td>
        </tr>

        <tr>
            <td width="140" align="right">姓：</td>
            <td width="250" valign="top">
                <p><input type="text" name="lastName" maxlength="20" size="16">
            </td>
        </tr>


        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <br>
                <input type="submit" name="Submit" value="提交" class="btn btn-primary block full-width m-b"
                       onclick="javascript:return(checkform());">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" name="Submit2" value="重置" class="btn btn-primary block full-width m-b">
            </td>
        </tr>

        <tr>
            <td width="140" align="right"></td>
            <td width="250" valign="top">
                <a href="admin_menu.jsp" class="btn btn-info" role="button">返回</a></td>
        </tr>
    </table>
</form>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap.min.js"></script>
</body>
</html>