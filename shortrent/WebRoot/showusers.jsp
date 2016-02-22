<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.Admin"%>
<%@ page import="ruanko.shortrent.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	List<User> users = (List<User>) session.getAttribute("userinfo");
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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<%
			Admin admin = (Admin) session.getAttribute("admininfo");
		%>
		<%
			if (admin != null)
				out.println(admin.getAdmin_name() + "<br>");
		%>

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
			<TBODY>
				<TR>
					<TD width=15 background=YHChannelApply.files/new_022.jpg>
						<IMG src="YHChannelApply.files/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>

						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<td>
														用户ID
													</td>
													<td>
														用户账号
													</td>
													<td>
														密码
													</td>
													<td>
														姓名
													</td>
													<td>
														性别
													</td>
													<td>
														移动电话
													</td>
													<td>
														备注
													</td>
													<td>
														操作
													</td>
												</TR>
												<%
													for (int i = 0; i < users.size(); i++) {
														User user = (User) users.get(i);
												%>
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<td><%=user.getUser_id()%></td>
													<td><%=user.getUser_account()%></td>
													<td><%=user.getUser_password()%></td>
													<td><%=user.getUser_name()%></td>
													<td><%=user.getUser_sex()%></td>
													<td><%=user.getUser_phone()%></td>
													<td><%=user.getUser_text()%></td>
													<td>
														<a
															href="deletedetail.jsp?user_id=<%=user.getUser_id()%>">删除</a>
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
					</TD>
					<TD width=15 background=YHChannelApply.files/new_023.jpg>
						<IMG src="YHChannelApply.files/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15>
						<IMG src="YHChannelApply.files/new_024.jpg" border=0>
					</TD>
					<TD align=middle width="100%"
						background=YHChannelApply.files/new_025.jpg height=15></TD>
					<TD width=15>
						<IMG src="YHChannelApply.files/new_026.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</body>
</html>
