<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>成为车主</title>
<link rel="stylesheet" href="source/member/css/style.default.css" type="text/css" />
<script type="text/javascript" src="source/member/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="source/member/js/custom/general.js"></script>
<script type="text/javascript" src="source/member/js/custom/messages.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="source/member/js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
<script type="text/javascript">
	
</script>
</head>

<body class="withvernav">
	<div class="bodywrapper">

		<c:import url="header.jsp"></c:import>

		<div class="vernav2 iconmenu">
			<ul>
				<li><a href="beOwner.do" class="buttons">成为车主</a></li>
				<li><a href="beTenant.do" class="buttons">成为租客</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">
			<div class="pageheader notab">
				<h1 class="pagetitle">成为车主</h1>
				<span class="pagedesc">查看和修改车主信息</span>

			</div>
			<!--pageheader-->

			<div id="basicform" class="subcontent">

				<div class="contenttitle2">
					<h3>成为车主</h3>
				</div>
				<form class="stdform" action="member/beCarOwnerAct.do" method="post" enctype="multipart/form-data">
					<p>
						<label>请输入真实姓名</label> <span class="field"><input name="realname" type="text" class="smallinput"></span>
					</p>
					<p>
						<label>请输入身份证号</label> <span class="field"><input name="idcard" type="text" class="smallinput"></span>
					</p>
					<p>
						<label>请输入手机号码</label> <span class="field"><input name="phone" type="text" class="smallinput"></span>
					</p>
					<p>
						<label>请上传你的身份证正面图片</label> <span class="field"> <input type="file" name="file1" /></span>
					</p>
					<p>
						<label>请上传你的身份证背面图片</label> <span class="field"> <input type="file" name="file2" /></span>
					</p>
					<br clear="all" /> <br />

					<p class="stdformbutton">
						<button class="submit radius2">确认提交</button>
						<input type="reset" class="reset radius2" value="重新填写" />
					</p>
				</form>
				<br />
			</div>
			<!-- centercontent -->
		</div>
		<!--bodywrapper-->
</body>
</html>
