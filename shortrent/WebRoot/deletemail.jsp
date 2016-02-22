<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//得到要删除的新闻的id
	int mail_id = Integer.parseInt(request.getParameter("mail_id"));
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deletedetail.jsp' starting page</title>
    
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
    确认删除?<br>
    <form action="mailDelete" method="post">
    	<!-- 这里使用了隐藏域，我觉得这个id没有必要显示给用户，也不需要用户输入，但是需要在表单提交的时候能将这个id提交给服务器，所以使用了隐藏域 -->
    	<input type="hidden" value="<%= mail_id %>" name="mail_id">
    	<input type="submit" value="删除">
    </form>
    <a href="mailShowList" >返回用户信息列表</a>
  </body>
</html>
