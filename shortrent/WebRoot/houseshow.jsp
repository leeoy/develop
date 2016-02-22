<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.shortrent.entity.House"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'house.jsp' starting page</title>
    
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
				<%
					 List<House> houses = (List<House>)request.getAttribute("houselis");
					for(int i=0;i<houses.size();i++)
					{ House house=houses.get(i);
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
						房屋名称：<%=house.getHouse_name()%>
						<br>
						房屋地址:<%=house.getHouse_address()%>
						
					</td>
					<td>
					房租：<%=house.getHouse_price()%><a>元/天</a>
					<br>
					适合人数：<%=house.getHouse_suithuman()%>
					<br>
					房屋配套：<%=house.getHouse_support()%>
					<br>
					</td>
					<td>
					是否通过审核：<%=house.getHouse_state()%>
					</td>
					<td>
					<a href='deletehouse?id=<%=house.getHouse_id()%>'>删除</a>
					<% 
					 if("no".equals(house.getHouse_state()))
					%>
					 <a href='ChangeHouseState?houseid=<%=house.getHouse_id()%>'>同意发布</a>
					<%
					 ;
					%>
					</td>
				</tr>
				<% }%>
			</table>
  </body>
</html>
