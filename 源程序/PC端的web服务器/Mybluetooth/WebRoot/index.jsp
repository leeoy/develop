<%@ page language="java" import="java.util.*,java.sql.Date"
	pageEncoding="UTF-8"%>
<%@ page import="com.zhn.entity.news"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//从request里获取新闻列表
	List<news> list = (List<news>) request.getAttribute("news");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'showusers.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="YHChannelApply.files/Style.css" type=text/css
			rel=stylesheet>
		<LINK href="YHChannelApply.files/Manage.css" type=text/css
			rel=stylesheet>
		<link rel="stylesheet" href="css/button.css">

	</head>

	<body>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15>
						<IMG src="YHChannelApply.files/new_019.jpg" border=0>
					</TD>
					<TD width="100%" background=YHChannelApply.files/new_020.jpg
						height=20></TD>
					<TD width=15>
						<IMG src="YHChannelApply.files/new_021.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			
			<TR>
				<TD>
					<TABLE id=grid
						style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
						cellSpacing=1 cellPadding=2 rules=all border=0>
			<TBODY>
				<TR
			      style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
				<td>
				蓝牙地址
				</td>
				<td>
				机主动态
			    </td>
				
			<td>操作</td>
		</TR>
		<%
				for (int i = 0; i < list.size(); i++) {
				news news = (news) list.get(i);
		%>
	<TR
	style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
	<td><%=news.getMac()%></td>
			<td><%=news.getNote()%></td>
			
					<td>
		<a
		href="del?mac=<%=news.getMac()%>"
									>删除</a>
									<a href="upPage?mac=<%=news.getMac()%>&note=<%=news.getNote()%>">修改</a>
													</td>
												</TR>
												<%
													}
												%>


											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
				
	<a href="news_add.jsp">增加</a>	
</html>
