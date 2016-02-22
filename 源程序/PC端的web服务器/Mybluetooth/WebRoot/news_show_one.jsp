<%@ page language="java" import="java.util.*,java.sql.Date" pageEncoding="UTF-8"%>

<%@ page import="com.zhn.entity.news" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<%news news = (news)request.getAttribute("news"); %>

    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
  <div align="center">

  </div>
  <hr>
  <br>
  <br>
  <br>
 
  <table align="center">
<tr><td>
蓝牙地址：</td><td><%=news.getMac()%></td></tr>
<tr><td>
机主动态：</td><td><%=news.getNote() %></td></tr>


</table>

</body>


 
</html>
