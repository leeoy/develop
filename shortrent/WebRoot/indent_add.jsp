<%@ page language="java" import="java.util.*,java.sql.Date" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.days" %>
<%@ page import="ruanko.shortrent.entity.User" %>
<%@ page import="ruanko.shortrent.entity.House" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//从request里获取新闻列表
	days days = (days)request.getAttribute("day");
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
  

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" charset="UTF-8">
function Check(){ 
if(document.getElementById('renter_id').value=='') {  alert('必须输入租客编号!');  document.getElementById('renter_id').focus();  return false; } 
if(document.getElementById('indent_check_in_time').value=='') {  alert('必须输入租房时间');  document.getElementById('indent_check_in_time').focus();  return false; } 
if(document.getElementById('indent_leave_time').value=='') {  alert('必须输入离开时间');  document.getElementById('indent_leave_time').focus();  return false; } 
if(document.getElementById('house_id').value=='') {  alert('必须输入租房编号');  document.getElementById('house_id').focus();  return false; }
}
</script>

<body>

<% 
  		User user = (User)session.getAttribute("userinfo");
%>
    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
  <div align="center">
  <a href="index_login.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
  <table align="center">
<form name="form1" action="indentAdd" method="post" onsubmit="return Check()">
租客编号：<input type="text" name="renter_id" readonly="readonly" value="<%=user.getUser_id() %>"/><br><br>
入住时间：<input type="text" name="indent_check_in_time" onfocus="WdatePicker({disabledDates:[<%=days.getDays()%>]})"/><br><br>
离开时间：<input type="text" name="indent_leave_time" onfocus="WdatePicker({disabledDates:[<%=days.getDays()%>]})"/><br><br>
租房编号：<input type="text" name="house_id" readonly="readonly" value="<%=days.getId()%>"/><br><br>
<input type="submit" value="提交" />
</form>
</table>
</body>


 
</html>
