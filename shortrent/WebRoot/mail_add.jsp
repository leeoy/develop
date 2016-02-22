<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.User" %>
<%@ page import="ruanko.shortrent.entity.House" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<House> house = (List<House>)request.getAttribute("house");
	House houses=house.get(0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addusers.jsp' starting page</title>
    
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
    
<%
	User user = (User)session.getAttribute("userinfo");
 %>
    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
<div align="center">
  <a href="index_login.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
  <table align="center">
<form name="form1" action="mailAdd" method="post" onsubmit="return Check()">
发件人：<input type="text" name="sender_id" size="40" readonly="readonly" value="<%=user.getUser_id() %>"/><br><br>
收件人：<input type="text" name="receiver_id" size="40" readonly="readonly" value="<%=houses.getOwner_id() %>"/><br><br>
邮件内容：<textarea name="mail_note" rows="20" cols="60"></textarea><br><br>
<input type="submit" value="提交"  target="_blank"/>
</form>
</table>
  </body>
</html>
