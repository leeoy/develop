<%@ page language="java" import="java.util.*,java.sql.Date"
	pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.indent"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//从request里获取新闻列表
	List<indent> list = (List<indent>) request.getAttribute("indent");
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
														租客编号
													</td>
													<td>
														租客姓名
													</td>
													<td>
														租客性别
													</td>
													<td>
														租客电话
													</td>
													<td>
														房屋名称
													</td>
													<td>
														房屋类型
													</td>
													<td>
														入住日期
													</td>
													<td>
														离开日期
													</td>
													<td>
														入住天数
													</td>
													<td>
														价格总计
													</td>
													<td>
														状态
													</td>
													<td>
														操作
													</td>
												</TR>
												<%
													for (int i = 0; i < list.size(); i++) {
														indent indent = (indent) list.get(i);
												%>
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<td><%=indent.getRenter_id()%></td>
													<td><%=indent.getRenter_name()%></td>
													<td><%=indent.getRenter_sex()%></td>
													<td><%=indent.getRenter_tel()%></td>
													<td><%=indent.getHouse_name()%></td>
													<td><%=indent.getHouse_type()%></td>
													<td><%=indent.getIndent_check_in_time()%></td>
													<td><%=indent.getIndent_leave_time()%></td>
													<td><%=indent.getIndent_check_in_day()%>天
													</td>
													<td><%=indent.getTot_amt()%>元
													</td>
													<td>
														未处理
													</td>
													<td>
														<a
															href="indentDelete?indent_id=<%=indent.getIndent_id()%>">删除</a>
														&nbsp;&nbsp;
														<a
															href="indentupdate?indent_id=<%=indent.getIndent_id()%>">通过订单申请</a>
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
</html>
