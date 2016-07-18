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

<title>控制台页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="source/member/css/style.default.css" type="text/css" />
<script type="text/javascript" src="source/member/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.flot.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.flot.resize.min.js"></script>
<script type="text/javascript" src="source/member/js/plugins/jquery.slimscroll.js"></script>
<script type="text/javascript" src="source/member/js/custom/general.js"></script>
<script type="text/javascript" src="source/member/js/custom/dashboard.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="source/member/js/plugins/excanvas.min.js"></script><![endif]-->
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
				<li><a href="beOwner.do" class="buttons">成为车主</a></li>
				<li><a href="beTenant.do" class="buttons">成为租客</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<div class="centercontent">
			<div class="pageheader">
				<h1 class="pagetitle">康云租赁</h1>
				<!-- <span class="pagedesc">页面的描述内容</span> -->

				<ul class="hornav">
					<li class="current"><a href="#updates">最新更新</a></li>
					<li><a href="#activities">最近活动</a></li>
				</ul>
			</div>
			<div id="contentwrapper" class="contentwrapper">
				<div id="updates" class="subcontent">
					<div class="notibar announcement">
						<a class="close"></a>
						<h3>公告</h3>
						<p>欢迎进入您的个人中心</p>
					</div>
				</div>
			</div>
			<div id="activities" class="subcontent" style="display: none;">&nbsp;</div>
		</div>
		<br clear="all" />
	</div>
	</div>
</body>
</html>
