<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<STYLE type=text/css>BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
</STYLE>

  </head>
  
  <body>
  <FORM id=form1 name=form1 onsubmit="javascript:return WebForm_OnSubmit();" 
action="UserLogin" method=post>
<DIV><INPUT id=__EVENTTARGET type=hidden name=__EVENTTARGET> <INPUT 
id=__EVENTARGUMENT type=hidden name=__EVENTARGUMENT> <INPUT id=__VIEWSTATE 
type=hidden 
value=/wEPDwUKLTMxMzU2OTkzM2QYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFA2J0bmF2stSMyj1cbWFEH2tzan/b7XAS 
name=__VIEWSTATE> </DIV>
<SCRIPT type=text/javascript>
<!--
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
// -->
</SCRIPT>
<SCRIPT type=text/javascript>
<!--
function WebForm_OnSubmit() {
if (typeof(ValidatorOnSubmit) == "function" && ValidatorOnSubmit() == false) return false;
return true;
}
// -->
</SCRIPT>

<SCRIPT type=text/javascript>
//<![CDATA[
Sys.WebForms.PageRequestManager._initialize('ScriptManager1', document.getElementById('form1'));
Sys.WebForms.PageRequestManager.getInstance()._updateControls(['tUpdatePanel1'], [], [], 90);
//]]>
</SCRIPT>
<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<SCRIPT language=JavaScript> 
var speed=20;
var temp=new Array(); 
var clipright=document.body.clientWidth/2,clipleft=0 
for (i=1;i<=2;i++){ 
	temp[i]=eval("document.all.div"+i+".style");
	temp[i].width=document.body.clientWidth/2;
	temp[i].height=document.body.clientHeight;
	temp[i].left=(i-1)*parseInt(temp[i].width);
} 
function openit(){ 
	clipright-=speed;
	temp[1].clip="rect(0 "+clipright+" auto 0)";
	clipleft+=speed;
	temp[2].clip="rect(0 auto auto "+clipleft+")";
	if (clipright<=0)
		clearInterval(tim);
} 
tim=setInterval("openit()",100);
                </SCRIPT>

<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="login_files/login_1.jpg" 
  border=0></TD></TR>
  <TR>
    <TD background=login_files/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id="user_account" 
                  style="WIDTH: 130px" name="user_account"></TD>
                <TD style="HEIGHT: 28px" width=370><SPAN 
                  id=RequiredFieldValidator3 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px">
                <INPUT id="user_password" style="WIDTH: 130px" type=password name="user_password">
                <a href="pwdbackun.jsp">忘记密码？</a>
                </TD>
                <TD style="HEIGHT: 28px"><SPAN id=RequiredFieldValidator4 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD><INPUT id=btn 
                  style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
                  onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("btn", "", true, "", "", false, false))' 
                  type=image src="login_files/login_button.gif" name=btn> 
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="login_files/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>
<SCRIPT type=text/javascript>
<!--
var Page_Validators =  new Array(document.getElementById("RequiredFieldValidator3"), document.getElementById("RequiredFieldValidator4"));
// -->
</SCRIPT>

<SCRIPT type=text/javascript>
<!--
var RequiredFieldValidator3 = document.all ? document.all["RequiredFieldValidator3"] : document.getElementById("RequiredFieldValidator3");
RequiredFieldValidator3.controltovalidate = "txtName";
RequiredFieldValidator3.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator3.initialvalue = "";
var RequiredFieldValidator4 = document.all ? document.all["RequiredFieldValidator4"] : document.getElementById("RequiredFieldValidator4");
RequiredFieldValidator4.controltovalidate = "txtPwd";
RequiredFieldValidator4.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
RequiredFieldValidator4.initialvalue = "";
// -->
</SCRIPT>

<DIV><INPUT id=__EVENTVALIDATION type=hidden 
value=/wEWBQKHmOW2AwLEhISFCwKd+7qdDgLChPy+DQKSoqqWDwNN1E3vW0gpbdtBgVWKbj2bcHhs 
name=__EVENTVALIDATION> </DIV>
<SCRIPT type=text/javascript>
<!--
var Page_ValidationActive = false;
if (typeof(ValidatorOnLoad) == "function") {
    ValidatorOnLoad();
}

function ValidatorOnSubmit() {
    if (Page_ValidationActive) {
        return ValidatorCommonOnSubmit();
    }
    else {
        return true;
    }
}
// -->
</SCRIPT>

<SCRIPT type=text/javascript>
<!--
Sys.Application.initialize();
// -->
</SCRIPT>
</FORM>
  </body>
</html>
