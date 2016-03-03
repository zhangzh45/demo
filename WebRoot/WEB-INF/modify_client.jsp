<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改员工信息</title>
    <link href="layout.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="jquery-ui.css">
		<script  type="text/javascript"  src="js/jquery-1.10.2.js"></script> 
	<script type="text/javascript">

	function update_page(info){
	var json=eval(info);
	var str=json.info;
	$("#identityIdInfo").html(str);
	}

	
	</script>
	 <style>
	 body{height:100%;margin:0;min-height:100%;padding:0;width:100%;background-color:#333;}
.body1{height:100%;margin:0 auto;min-height:100%;padding:0;width:980px;}
#container{width:100%;height:100%;
background:-moz-linear-gradient(center top , #000000, #000000) repeat scroll 0 0 transparent;
background:-webkit-gradient(linear,left top,left bottom,color-stop(0, #000000),color-stop(1, #000000));
}
a{color: rgb(0, 114, 191); text-decoration: none;}
.msg{font-size:18px;color:#555;text-align:center;}
.legal{text-align:center;color:5f5f5f;background-color:#DEDEDE;font-size:16px;margin-top:100px;}
.label{font-size:24px;color:#777;margin-top:20px;text-align:center;}
.clearfix{clear:both;float:none;}
/*注册*/
*:focus{outline:none; /* Prevents blue border in Webkit */}
form {margin: 20px auto;}
p {line-height: 1.6;}
#tw-outer{background:url("images/bg-clouds.png") repeat-x scroll 0 0 #000000;height:385px;}
#tw-logo{margin-left:192px;width:180px;}
#tw-logo img{margin-top:10px;}
.content-bubble-arrow  {background-image:url("images/arr2.gif");background-position:32px 0;background-repeat:no-repeat;height:11px;overflow:hidden;}
#tw{margin:auto auto  auto auto;width:575px;padding:10px;-moz-border-radius:5px;-webkit-border-radius:5px;border-radius:5px;background:#fff;}
#tw label , #gaiaOnline label{float:left;width:95px;color:#666666;text-align:right;padding:10px 10px 0 0;font:16px 'Lucida Grande',sans-serif;}
#tw input, #tw  textarea , #gaiaOnline input , #gaiaOnline textarea{
background-color:#fff;border:1px solid #ccc;font-size:18px;margin:0;padding:8px;
width:200px;display:block;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;
-webkit-transition: all 0.5s ease-in-out;-moz-transition: all 0.5s ease-in-out;transition: all 0.5s ease-in-out;float:left;}

#tw textarea {min-height:200px;}
#tw input:hover, #tw textarea:hover {border-color:inherit !important;background-color:#EfEfEf;-webkit-border-radius:5px 0 0 5px;
-moz-border-radius:5px 0 0 5px;border-radius:5px 0 0 5px;}

/* The interesting bit */
#tw input:not(:focus),#tw textarea:not(:focus) {opacity:0.6;}
#tw  input:required,#tw  textarea:required {}
#tw  input:valid,#tw  textarea:valid {opacity:0.8;}
#tw input:focus:invalid,#tw textarea:focus:invalid {border:1px solid red;background-color:#FFEFF0;}
#tw input[type=submit] {float:right;
background:none;font-size:15px;opacity:1;padding:5px;
width:150px;-moz-border-radius:5px;-webkit--border-radius:5px;border-radius:5px;
cursor:pointer;margin-bottom:-10px;margin-left:103px;margin-top:10px;
border-style: solid;
text-shadow:1px 1px 0 #FFFFFF;border-color:#DDDDDD #DDDDDD #CCCCCC;color: #333;
}
#tw .outerDiv{-webkit-transition: all 1s linear;margin-bottom:16px;margin-top:8px;}
#tw .outerDiv:hover .message{opacity:1;display:block;}
#tw .message{
width:200px;float:left;opacity:0;-moz-border-radius:0 10px 10px 0;-webkit-border-radius:0 10px 10px 0;
border-radius-bottomright:0 10px 10px 0;background:url("images/signup_info.gif") no-repeat scroll 13px 50% #F2F2F2;
border-color:#DBDBDB;border-style:solid;border-width:1px 1px 1px 2px;color:#666666;display:none;font-size:12px;
line-height:1.45em;padding:0.85em 10px 0.85em 30px;
text-transform:lowercase;}
.clearfix{clear:both;}
	.topleft{color:white;background-color:#222222;height:40px;margin-top:0;font-family:calibri;}
	 </style>
  </head>
  
  <body>
  <div class="topleft"><h1> 
	organization system 
	</h1></div>
	<div class="body1">
  <div id="container">
<br><br><br>
<div class="label">修改员工信息</div>
<br><br>
<div id="tw-outer">
<div id="tw">
<s:form action="UpdateClient" namespace="/client">
<div id='name' class='outerDiv'>
<s:textfield name="id" label="id"  readonly="true"></s:textfield>
</div>
<div class='clearfix'></div>
<div id='username' class='outerDiv'>
<s:textfield name="firstname" label="名"></s:textfield>
</div>
<div class='clearfix'></div>
<div id='password' class='outerDiv'>
<s:textfield name="lastname" label="姓"></s:textfield> 
</div>
<div class='clearfix'></div>
<div id='password' class='outerDiv'>
<s:textfield name="ag" label="年龄"></s:textfield>
</div>
<div class='clearfix'></div>
<div id='password' class='outerDiv'>
<s:textfield name="gend" label="性别"></s:textfield>
</div>
<div class='clearfix'></div>
<div class='clearfix'></div>
 <div id='submit' class='outerDiv'>
<input type="submit" value="保存" /> 
</div>
<s:actionmessage/>
 </s:form>

<br>
<div class="clearfix"></div>
</div>
</div>
<br>
  </div>
  </div>
  </body>
</html>
