<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.shortrent.entity.House" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	
	House house = (House)session.getAttribute("house");
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <script src="slide.js" type="text/javascript"></script>
    
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
  <a href="index_login.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
<div>
<table align="center">
<tr>
<td>
    <div id="focusViwer">
<div id="imgADPlayer"></div> 
<script> 
PImgPlayer.addItem( "<%=house.getHouse_name()%>","upload/<%=house.getHouse_img1()%>"); 		
PImgPlayer.addItem( "<%=house.getHouse_name()%>","upload/<%=house.getHouse_img2()%>"); 		
PImgPlayer.addItem( "<%=house.getHouse_name()%>","upload/<%=house.getHouse_img3()%>"); 			
PImgPlayer.init( "imgADPlayer", 480, 320);   
</script>
</td>
		<td>
		<div class="span3.5" style=" float:right: 200px; bottom: 20px; width: 400px;">
			<fieldset>
				<legend>
					房屋信息
				</legend>
				<br>
				<br>
				<br>
				房屋名称：<%=house.getHouse_name() %>
				<br>
				<br>
				地址：<%=house.getHouse_address() %>
				<br>
				<br>
				房屋类型：<%=house.getHouse_type() %>
				<br>
				<br>
				适住人数：<%=house.getHouse_suithuman() %>
				<br>
				<br>
				配套设施:<%=house.getHouse_support() %>
				<br>
				<br>
				租金：<%=house.getHouse_price() %>
				<br>
				<br>
				<a href="days?id=<%=house.getHouse_id()%>" class="btn btn-primary" target="_blank">下订单</a>
			</fieldset>
		</div>
		</td>
		</tr>
		</table>
</div>
  </body>
</html>
