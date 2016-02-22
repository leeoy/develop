<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadimage.jsp' starting page</title>
    
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
    <center>  
    <h3>文件上传</h3>  
    <font color="red"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %> </font>  
    <form enctype="multipart/form-data" method="post" action="Upload?id=<%=Integer.parseInt(request.getParameter("id"))%>">  
        文件描述：<input type="text" name="text" /><br/>  
        选择文件：<input type="file" name="house_img1" /><br/>  
        选择文件：<input type="file" name="house_img2" /><br/>  
        选择文件：<input type="file" name="house_img3" /><br/>   
        <input type="submit" value="上传" />  
    </form>  
  </center>  
  </body>
</html>
