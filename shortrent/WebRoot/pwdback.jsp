<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ruanko.shortrent.entity.User"%>
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
    
    <title>My JSP 'pwdback.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script language="javascript">
        document.check.user_answer.focus();
        function test(){
             var f=document.check;
             var newQust =f.user_answer.value;
             if(newQust == ""){
                  alert("请输入密保问题!");
                  f.user_answer.value='';
                  f.user_answer.focus();
                  return false;
             }
        }
       
    </script>
  
  <body>
    <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div>
  </div>
<div align="center">
  <a href="index.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
    <center>
           <form method="post" name="check" action="UserPwdBack">
           <input type="hidden" name="user_id" value="<%=user.getUser_id() %>" />
              <table>
                  <tr><th colspan="3">密码找回</th></tr>
                  <tr><td><br><br></td></tr>
                  <tr>
                     <td>密保问题</td>
                     <td><input name="user_question" type="text" value="<%=user.getUser_question() %>"/></td>
                  </tr>
                  
                  <tr>
                     <td>密保答案</td>
                     <td><input name="user_answer" type="text"/></td>
                  </tr>
              </table>
              <br>
              <input name="check" value="下一步" type="submit" onclick="return test()"/>
           </form>
        </center>
  </body>
</html>
