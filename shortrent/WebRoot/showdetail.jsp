<%@ page language="java" import="java.util.*,ruanko.shortrent.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.mail" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <% 
    	mail mail=(mail)request.getAttribute("mail1");
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showdetail.jsp' starting page</title>
    
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
	<table>
	<tr>
	<td>邮件编号</td>
	<td>发件人</td>
	<td>收件人</td>
	<td>邮件内容</td>
    <td>邮件时间</td>
	</tr>
	<tr>
	<td><%=mail.getMail_id() %></td>
	<td><%=mail.getSender_id()%></td>
	<td><%= mail.getReceiver_id()%></td>
	<td><%=mail.getMail_note() %></td>
	<td><%=mail.getMail_time() %></td>
	
	</tr>
	</table>
	<a href="mailShowList">返回列表</a>
  </body>
</html>
