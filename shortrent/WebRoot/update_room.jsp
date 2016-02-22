<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.shortrent.entity.House"%>
<%@ page import="ruanko.shortrent.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="gbk" />
		<title>轻松短租网</title>
		<meta name="viewport" content="width=device-width ,initial-scale=1.0">
		 <!-- 最新 Bootstrap 核心 CSS 文件 -->
			<link rel="stylesheet" href="css/bootstrap.css">
				<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
				<script src="js/jquery.min.js"></script>
				<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
				<script src="js/bootstrap.js"></script>
	</head>
	<body>
	<% 
  		User user = (User)session.getAttribute("userinfo");
  	%>
	<div class="container">
		<h1 class="page-header">
			轻松短租网
		</h1>
		<% 
	               List<House> houses = (List<House>)request.getAttribute("houselis");
					 House house=houses.get(0);
					 %>
				<form method="post" action="updatehouse?houseid=<%=house.getHouse_id()%>">
					<legend>
						房屋信息
					</legend>
					租金：<input type="text" id="price" name="price" value="<%=house.getHouse_price()%>"><a>元/月</a>
					<br>
						<br>
							地址：<input type="text" id="address" name="address" value="<%=house.getHouse_address()%>"/>
									<br>
										<br>
											适住人数：<input type="text" id="suithuman" name="suithuman" value="<%=house.getHouse_suithuman()%>"/>
											<br>
												<br>
												房屋配套：
							<input type="checkbox" name="house_support" value="WiFi">
							WiFi
							<input type="checkbox" name="house_support" value="热水">
							热水
							<input type="checkbox" name="house_support" value="空调">
							空调
							<input type="checkbox" name="house_support" value="家电">
                                                                        家电
							<input type="submit" value="提交修改">
							
				</form>
	
		</body>
</html>
