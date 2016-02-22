<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwdbackun.jsp' starting page</title>
    
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
        document.pwdb.user_account.focus();
        function test(){
             var f=document.pwdb;
             var newQust =f.user_account.value;
             if(newQust == ""){
                  alert("请输入用户名!");
                  f.user_account.value='';
                  f.user_account.focus();
                  return false;
             }
        }
       
    </script>
  
  <body>
  <div align="center"><div style="background-image:url(image/yyyyy.gif);width:1000px;height:200px">
  </div></div>
  <div align="center">
  <a href="index.jsp">返回主页</a>
  </div>
  <hr>
  <br>
  <br>
  <br>
     <center>
           <form method="post" name="pwdb" action="/shortrent/UserPwdBackUn">
              <table>
                  <tr><th colspan="3">密码找回</th></tr>
                  <tr><td><br><br></td></tr>
                  <tr>
                     <td>请输入用户名:</td>
                     <td><br><br></td>
                     <td><input name="user_account" type="text" /></td>
                  </tr>
              </table>
              <input id="pwdb" value="下一步" type="submit" onclick="return test()"/>
           </form>
        </center>
  </body>
</html>
