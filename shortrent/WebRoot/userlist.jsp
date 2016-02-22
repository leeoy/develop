<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.User" %>
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
    
    <title>My JSP 'showusers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/button.css">
  </head>
  
  <body>
显示用户信息内容 <br>
   用户名:<h1><%=user.getUser_account()%></h1> 
   <br>姓名:<%=user.getUser_name() %>
   <br>性别:<%=user.getUser_sex() %>
   <br>手机:<%=user.getUser_phone() %>
   <br>备注:<%=user.getUser_text() %>
   <br> <a href="UserUpdate?user_id=<%= user.getUser_id() %>" class="button white">修改</a> <a href="UserPwdUpdate?user_id=<%= user.getUser_id() %>" target="_blank" class="button white">修改密码</a>
  </body>
</html>
