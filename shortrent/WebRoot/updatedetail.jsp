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
    
    <title>My JSP 'updatedetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     修改用户信息<br>
    <form action="UserUpdateDo" method="post">
    	<input type="hidden" name="user_id" value="<%= user.getUser_id() %>" />
    	用户名：<input type="text" name="user_account" value="<%= user.getUser_account() %>" />
		<br>姓名：<input type="text" name="user_name" value="<%= user.getUser_name() %>" />
    	<br>性别<input type="radio" name="user_sex" value="男" id="m">男<input type="radio" name="user_sex" value="女" id="f">女</td>
    	<br>手机号：<input type="text" name="user_phone" value="<%= user.getUser_phone() %>" />
    	<br>备注：<textarea name="user_text" rows="5" cols="50"  ><%= user.getUser_text() %></textarea>
    	<br><input type="submit" value="保存修改">
    </form>

  </body>
</html>
