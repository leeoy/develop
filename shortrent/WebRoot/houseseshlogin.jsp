<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.shortrent.entity.House"%>
<%@ page import="ruanko.shortrent.entity.User"%>
<%
	
	List<House> list = (List<House>)session.getAttribute("house");
	
	
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <% 
  		User user = (User)session.getAttribute("userinfo");
  	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'housesh.jsp' starting page</title>
    
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

<div align="center">
<a href="UserLogin?user_account=<%=user.getUser_account() %>&user_password=<%=user.getUser_password() %>">返回主页</a>
</div>
<hr>
    <table align="center">
    		 <%
	   	for (int i = 0; i < list.size(); i++){
	   	   	House house = (House)list.get(i);
	   	   System.out.println(house.getHouse_id());
	   	   	
	   %>
				<tr>
					<td>
						<img
							src="upload/<%=house.getHouse_img1()%>"
							width="200px" height="160px" />
					</td>
					<td>
						房屋类型：<%=house.getHouse_type()%>
						<br>
						房屋名称：<a href="foundimage?id=<%=house.getHouse_id()%>" target="_blank"><%=house.getHouse_name()%></a>
						<br>
						房屋地址:<%=house.getHouse_address()%>
						<br>
						房租：<%=house.getHouse_price()%><a>元/天</a>
						<br>
						适合人数：<%=house.getHouse_suithuman()%>
						<br>
						房屋配套：<%=house.getHouse_support()%>
						<br>
					</td>
					
				</tr>
				<tr>
        <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="mail_add?houseid=<%=house.getHouse_id() %>" target="_blank">给房主发信</a></td>
      </tr>
				<tr>
				<td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="days?id=<%=house.getHouse_id()%>">下订单</a></td>
				</tr>
				<% }%>
			</table>
		
  </body>
</html>
