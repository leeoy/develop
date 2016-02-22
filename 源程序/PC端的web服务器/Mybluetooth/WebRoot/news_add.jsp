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


    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
  <div align="center">
  <a href="show">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
  <table align="center">
<form name="form1" action="add" method="post" >
蓝牙地址：<input type="text" name="mac" /><br><br>

机主动态：<input type="text" name="note"/><br><br>
<input type="submit" value="提交" />
</form>
</table>
</body>


 
</html>
