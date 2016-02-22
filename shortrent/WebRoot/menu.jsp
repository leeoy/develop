<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="ruanko.shortrent.entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
		<% 
  	User user = (User)session.getAttribute("userinfo");
  	%>
		</h4>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<BODY>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 
background=image/menu_bg.jpg border=0>
  <TR>
    <TD vAlign=top align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        
        <TR>
          <TD height=10></TD></TR></TABLE>
      
          
     
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=image/menu_bt.jpg><A 
            class=menuParent onclick=expand(6) 
            href="javascript:void(0);">我是房东</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child6 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="yes?id=<%=user.getUser_id()%>" 
            target="show">已处理订单</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="no?id=<%=user.getUser_id()%>" 
            target="show">未处理订单</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="houselist?owner_id=<%=user.getUser_id()%>" 
            target="show">我的房屋</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="add_room.jsp"
            target="show">添加房屋</A></TD></TR>
        </TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=image/menu_bt.jpg><A 
            class=menuParent onclick=expand(7) 
            href="javascript:void(0);">我是房客</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child7 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="indentShowList?id=<%=user.getUser_id()%>"
            target="show">查看我的订单</A></TD></TR>
        </TABLE>
         
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=image/menu_bt.jpg><A 
            class=menuParent onclick=expand(2) 
            href="javascript:void(0);">邮件中心</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="mailShowList?userinfo=<%=user.getUser_id()%>" 
            target="show">收件箱</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
          href="sendbox?userinfo=<%=user.getUser_id()%>" 
            target="show">发件箱</A></TD></TR>
       </TABLE>
     
     
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=image/menu_bt.jpg><A 
            class=menuParent onclick=expand(0) 
            href="javascript:void(0);">个人管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child0 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="UserShow?id=<%=user.getUser_id()%>"
            target="show">修改个人信息</A></TD></TR>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="image/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            onclick="if (confirm('确定要返回主页吗？')) return true; else return false;" 
            href="UserLogin?user_account=<%=user.getUser_account() %>&user_password=<%=user.getUser_password() %>"
            target=_top>返回主页</A></TD></TR></TABLE></TD>
    <TD width=1 bgColor=#d1e6f7></TD></TR></TABLE></BODY></HTML>
