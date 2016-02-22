<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ruanko.shortrent.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
		User user = (User)session.getAttribute("userinfo");
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwdbackupdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script language="javascript">
        document.register.user_password.focus();
        function test(){
             var f=document.register;
             var newPsw1 =f.user_password.value;
             var newPsw2 = f.passwordtoo.value;
             if(newPsw1 == "" || newPsw2 == ""){
                  alert("密码框不能为空!");
                  f.user_password.value='';
                  f.passwordtoo.value='';
                  f.user_password.focus();
                  return false;
             }
             if(newPsw1 != newPsw2){
                  alert("两次密码输入不一致!");
                  f.user_password.value='';
                  f.passwordtoo.value='';
                  f.user_password.focus();
                  return false; 
             }
             return true;
        }
       
    </script>
  <body>
    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
<div align="center">
  <a href="index.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
    <center>
           <form method="post" name="register" action="UserPwdUpdateDo">
           <input type="hidden" name="user_id" value="<%= user.getUser_id() %>" />
              <input type="hidden" name="action" value="changePassword" />
              <table>
                  <tr><th colspan="3">密码修改</th></tr>
                  <tr><td><br><br></td></tr>
                  <tr>
                     <td>输入新密码：</td>
                     <td><input name="user_password" type="password"/></td>
                  </tr>
                  <tr>
                     <td>再输入一次：</td>
                     <td><input name="passwordtoo" type="password"/></td>
                  </tr>
              </table>
              <br>
              <input name="chapsubmit" value="提 &nbsp; 交" type="submit" onclick="return test()"/>
           </form>
        </center>
  </body>
</html>
