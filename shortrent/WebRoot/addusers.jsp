<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  
  <body background="image/image1.jpg">
    <script type="text/javascript">
	var reuser=/^[A-Za-z0-9]+$/;
	var count=5;
	function SexJudge(){ 
		var temp = false; 
		var xbObj1= document.getElementById("m"); 
		var xbObj2= document.getElementById("f"); 
		if(xbObj1.checked || xbObj2.checked){ 
		temp = true; 
		} 
	return temp; 
	} 
	function judge(){
		if(form1.user_account.value==""||!reuser.test(form1.user_account.value)||form1.user_account.value.length<4||form1.user_account.value.length>20){
			alert("用户账户不能为空！\n"+"用户账户必须为4-20位以上的字母、数字，不能含有非法字符！");
			form1.user_account.focus();
			return false;
		}
		if(form1.user_password.value==""){
			alert("用户密码不能为空，请输入！");
			form1.user_password.focus();
			return false;
		}
		if(form1.user_password1.value!=form1.user_password.value){
			alert("确认密码不正确，请重新输入！");
			form1.user_password1.focus();
			return false;
		}
		if(form1.user_question.value=="选择密码问题"){
			alert("没有选择密码找回问题！");
			form1.user_question.focus();
			return false;
		}
		if(form1.user_answer.value==""){
			alert("没有填写密码找回答案！");
			form1.user_answer.focus();
			return false;
		}
		if(!SexJudge()){
			alert("用户性别没有填写！");
			return false;
		}
	return true;
	}
</script>
<form name="form1" target="_parent" action="UserAdd" method="post" onSubmit="return judge();">
   <table border="0" width=600 align="center">
	<caption valign=center><p style="font-family:宋体;color:orange;font-size:30pt">轻松短租网</p></caption>
	   <tr> 
		<td align=center><font color=#000000>基本信息</font></td>
	   </tr>
	   <tr>
		<td>
		   <table border="0" cellspacing="0" width=600>
	   		<tr>
			   <td width=200><font color=red>*</font>用户账户：</td>
			   <td><input type="text" name="user_account" size="20"></td>
	   		</tr>
	   		<tr><td colspan="2">!4-20个字符（汉字、字母、数字、下划线）</td></tr>
			<tr>
			   <td><font color=red>*</font>密码：</td>
			   <td><input type="password" size="20" name="user_password"></td>
			</tr>
			<tr><td colspan="2">!6-12个字符</td></tr>
			<tr>
			   <td><font color=red>*</font>确认密码：</td>
			   <td><input type="password" size="20" name="user_password1"></td>
			</tr>
			<tr><td>!重复输入一次密码</td></tr>
			<tr>
			   <td>密码找回问题：</td>
			   <td><select name="user_question">
				<option value="选择密码问题">选择密码问题</option>
				<option value="你的生日">你的生日</option>
				<option value="你的姓名">你的姓名</option>
				<option value="你的英文名">你的英文名</option>
			       </select>
			   </td>
			</tr>
			<tr>
			   <td>密码找回答案：</td>
			   <td><input type="text" name="user_answer"></td>
			</tr>
		   </table>
		</td>
	   </tr>
	    <tr> 
		<td align=center><font color=#000000>附加信息（点击查看详细）</font></td>
	   </tr>
	   <tr>
		<td>
		   <table border="0" cellspacing="0" width=600>
	   		<tr>
			   <td width=200><font color=red>*</font>真实姓名：</td>
			   <td><input type="text" name="user_name"></td>
	   		</tr>
			<tr>
			   <td><font color=red>*</font>性别：</td>
			   <td><input type="radio" name="user_sex" value="男" id="m">男<input type="radio" name="user_sex" value="女" id="f">女</td>
			</tr>
	   		<tr>
			   <td><font color=red>*</font>手机号：</td>
			   <td><input type="text" name="user_phone"></td>
	   		</tr>
			<tr>
			   <td>用户协议：</td>
			   <td><textarea name="textarea" rows="6"cols="36" 								readonly="readonly">请仔细阅读以下协议:
	1.法律法规底线：有法可依、有法必依、执法必严、违法必究，任何时候，无论是网上网下，都将始终做到违法必究；
	2.社会主义制度底线，为我们全面建成小康社会提供了有力地制度保障，我们要积极拥护社会主义及社会主义制度；
	3.国家利益底线，作为国家公民，时刻维护我们伟大祖国的利益，这也是宪法赋予我们每位公民的光荣义务；
	4.公民合法权益底线，我们在网络反腐的同时，切忌不能以“艳照”等不健康、不正当甚至违法手段对别人进行，否则不仅触犯法律，也侵犯了无辜者的合法权益；
	5.社会公共秩序底线，网络世界必须也要遵循一定的秩序规则，唯有如此大家才能营造一个良好健康的网络环境；
	6.道德风尚底线，崇尚美德在我国延续几千年的优秀传统，网络空间里也要讲道德，不做有违道德之事；
	7.信息真实性底线，要求我们在上网时一定要实事求是，而不能以讹传讹、散发谣传，积极宣传政府部门发布的真实信息。</textarea></td>
			</tr>
		   </table>
		</td>
	   </tr>
	   <tr>
		<td align=center>
		   <input type="submit" id="register" value="确定">
   		   <input type="reset" value="重置">
		</td>
	   </tr>
   </table>
</form>
  </body>
</html>
