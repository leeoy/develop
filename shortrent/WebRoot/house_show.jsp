<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.House" %>
<%@ page import="ruanko.shortrent.entity.User" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	
	List<House> list = (List<House>)session.getAttribute("house");
	
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP  starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background:url(image/333.bmp)">
    	<table width="645" height="426" border="0">
    	  <tr>
	   <%
	   	for (int i = 0; i < 4; i++){
	   	   	House house = (House)list.get(i);
	   	   
	   	   	
	   %>

    <td>
	<table width="209" border="0">
      <tr>
        <td><img src="upload/<%=house.getHouse_img1() %>" width="200px" height="160px" ></td>
       
        </tr>
      <tr>
        <td><%=house.getHouse_name() %></td>
  </tr>
      <tr>
        <td><%=house.getHouse_price() %>元/天</td>
      </tr>
       
    </table>
 </td>

	    	
	    
	    <% 
	       }
	     %>
	     </tr>
	     </table>
  </body>
</html>
