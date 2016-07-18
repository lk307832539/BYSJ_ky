<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>
<link rel="stylesheet" href="source/member/css/style.default.css" type="text/css" />
<script type="text/javascript" src="source/member/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.alerts.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="source/member/js/custom/general.js"></script>
<script type="text/javascript" src="source/member/js/custom/messages.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="source/member/js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="withvernav">
	<div class="bodywrapper">

		<c:import url="header.jsp"></c:import>

		<div class="vernav2 iconmenu">
			<ul>
				<li><a href="member/carOwnerList.do" class="elements">车主管理</a></li>
				<li><a href="member/carTenantList.do" class="elements">租客管理</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">

			<div class="pageheader notab">
				<h1 class="pagetitle">车主详情</h1>
				<span class="pagedesc">这里可以查看车主详细信息</span>

			</div>
			<!--pageheader-->

			<div id="basicform" class="subcontent">

				<div class="contenttitle2">
					<h3>车主详情</h3>
				</div>
				<!--contenttitle-->
				<form class="stdform" action="" method="post" enctype="multipart/form-data">
					<p>
						<label>请输入真实姓名</label> <span class="field"><input name="realname" type="text" class="smallinput" value="${carOwne.realName }"></span>
					</p>
					<p>
						<label>请输入身份证号</label> <span class="field"><input name="idcard" type="text" class="smallinput" value="${carOwne.idCard }"></span>
					</p>
					<p>
						<label>请输入手机号码</label> <span class="field"><input name="phone" type="text" class="smallinput" value="${carOwne.phone }"></span>
					</p>
					<p>
						<label>请上传你的身份证正面图片</label> <span class="field"> <input type="file" name="file1" /></span> <img alt="" src="${carOwne.idCardFirImg }" style="width: 200px;height: 200px;">
					</p>
					<p>
						<label>请上传你的身份证背面图片</label> <span class="field"> <input type="file" name="file2" /></span> <img alt="" src="${carOwne.idCardSecImg }" style="width: 200px;height: 200px;">
					</p>
					<br clear="all" /> <br />

					<p class="stdformbutton">
						<button class="submit radius2">确认提交</button>
						<input type="reset" class="reset radius2" value="重新填写" />
					</p>
				</form>
				<c:choose>
					<c:when test="${user.isAdmin==true && carOwne.isChecked==false}">
						<h3 style="margin-left: 220px">请管理员审核并且选择车主基本信息是否通过审核</h3>
						<p style="margin-left: 220px">
							<a type="button" class="stdbtn btn_lime" href="carOwnerVerifyPass.do?ownerid=${carOwne.ownerId }">审核通过</a> 
							<a type="button" class="stdbtn" href="carOwnerVerifyDisPass.do?ownerid=${carOwne.ownerId }">审核不通过</a>
						</p>
					</c:when>
				</c:choose>
				<br />
			</div>
			<!-- centercontent -->


		</div>
		<!--bodywrapper-->
</body>
</html>
