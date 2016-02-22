<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="ruanko.shortrent.entity.mail"%>
<%@ page import="ruanko.shortrent.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
			User user = (User) session.getAttribute("userinfo");
		%> 
<%
	//从request里获取新闻列表
	List<mail> list = (List<mail>)request.getAttribute("mail");
	
%>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="YHChannelApply.files/Style.css" type=text/css rel=stylesheet>
<LINK href="YHChannelApply.files/Manage.css" type=text/css rel=stylesheet>
<link rel="stylesheet" href="css/button.css">
<html>
	<a href="mailShowList?userinfo=<%=user.getUser_id() %>" class="button white">显示所有邮件</a> &nbsp; 
	<a href="mailShowListread?userinfo=<%=user.getUser_id() %>" class="button white">显示已读邮件</a>&nbsp;
	<a href="mailShowListnoread?userinfo=<%=user.getUser_id() %>" class="button white">显示未读邮件</a> 
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
 <TBODY>
  <TR>
    <TD width=15><IMG src="YHChannelApply.files/new_019.jpg" border=0></TD>
    <TD width="100%" background=YHChannelApply.files/new_020.jpg height=20></TD>
    <TD width=15><IMG src="YHChannelApply.files/new_021.jpg" 
  border=0></TD></TR></TBODY></TABLE>
  <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0> 
	<TBODY>
		<TR>
			<TD width=15 background=YHChannelApply.files/new_022.jpg>
				<IMG src="YHChannelApply.files/new_022.jpg" border=0>
			</TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				
				<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%"
					align=center border=0>
					<TBODY>
						<TR>
							<TD>
								<TABLE id=grid
									style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
									cellSpacing=1 cellPadding=2 rules=all border=0>
									<TBODY>
										<TR
											style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
											<TD>
												发件人
											</TD>
											<TD>
												收件人
											</TD>
											<TD>
												邮件内容
											</TD>
											<TD>
											         发件时间
											</TD>
											<TD>
												邮件状态
											</TD>
											<TD>
												操作
											</TD>
										</TR>
										<%
				for (int i = 0; i < list.size(); i++) {
					mail mail = (mail) list.get(i);
			%>
										<TR
											style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
											<TD>
												<a href="mailShow?id=<%=mail.getMail_id()%>" target="_blank"><%=mail.getSender_id()%></a>
											</TD>
											<TD>
												<%=mail.getReceiver_id()%>
											</TD>
											<TD>
												<%=mail.getMail_note()%>
											</TD>
											<TD>
												<%=mail.getMail_time()%>
											</TD>
											<TD>
												<%=mail.getMail_state()%>
											</TD>
											<td>
					                            <a href="deletemail.jsp?mail_id=<%=mail.getMail_id()%> class="button white">删除</a>
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
