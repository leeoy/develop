<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminindex.jsp' starting page</title>
    
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
  <div  align="center">
  <div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
</div>
</div>
<table border="0">
<tr>
<td>
  <h2>用户管理</h2>
     <a href="UserShowList" target="admin">显示用户信息</a><br>
   <h2>房屋管理</h2>
     <a href="Houseshow?state=no&i=1" target="admin">查看新增房屋</a><br>
     <a href="Houseshow?state=yes&i=1" target="admin">查看已发布房屋</a><br/>
    <h2>订单管理</h2>
     <a href="indentShow" target="admin">查看所有订单</a><br>
     <a href="indentshownolistadmin" target="admin">处理未处理订单</a><br/>
     <a href="index.jsp" target="admin">返回主页</a><br/>
 </td>
 <td>
 <div style="width:200px;height:300px">
 </div>
 </td>
 <td>
<div style="background-image:url(image/tip-5.jpg);width:750px;height:300px" align="center">
</div>
 </td>
 </tr>
  </body>
</html>
