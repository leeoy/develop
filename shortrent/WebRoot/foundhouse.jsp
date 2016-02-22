<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'foundhouse.jsp' starting page</title>

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
		<h1 class="page-header">
			轻松短租网
		</h1>
		<form method="post" action="house?action=Fuzzyquery">
			房屋地址：
			<input type="text" name="address" id="address" placeholder="按房屋地址搜索">
			房屋类型：
			<select name="house_type">
				<option value="别墅">
					别墅
				</option>
				<option value="公寓">
					公寓
				</option>
				<option value="楼房">
					楼房
				</option>
				<option value="经济适用房">
					经济适用房
				</option>
			</select>
			房屋适合人数：
			<input type="text" name="suithuman" id="suithuman"
				placeholder="按房屋适合人数搜索">
			房屋价格：
			<select name="price">
				<option value="0">
					500以下
				</option>
				<option value="500">
					500-1000
				</option>
				<option value="1000">
					1000-1500
				</option>
				<option value="1500">
					1500-2000
				</option>
				<option value="2000">
					2000-3000
				</option>
				<option value="3000">
					3000-3500
				</option>
				<option value="3500">
					3500-4000
				</option>
			</select>元/月
			房屋配套：
			<input type="checkbox" name="house_support" value="WiFi">
			WiFi
			<input type="checkbox" name="house_support" value="热水">
			热水
			<input type="checkbox" name="house_support" value="空调">
			空调
			<input type="checkbox" name="house_support" value="家电">
			家电
			<input type="submit" value="搜索房屋" />
		</form>
		<div id="testA"
			style="display: none; postion: resative; float: right; width: 75%; margin: 0; padding: 0 3% 0 0; background-color: #cccccc;">
			<jsp:include page="house.jsp" flush="true" />
		</div>
	</body>
</html>
