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

<title>查看消息</title>
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
		<div class="vernav iconmenu">
			<ul>
				<li class="current"><a href="manageblog.html" class="inbox">收件箱</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">信息查看</h1>
				<span class="pagedesc">请时时注意您的收件箱</span>

				<ul class="hornav">
					<li class="current"><a href="#inbox">信息详情</a></li>
				</ul>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div id="inbox" class="subcontent">
					<h1 style="text-align: center;">${message.massageContents.type}</h1>
					<h4 style="text-align: center;">${message.massageContents.postDate}</h4>

					<div class="profile_about" style="font-size: 20px;min-height: 150px;">
						${message.massageContents.massageContent}
					</div>
					</br>
					<div style="float: right;">
						<button class="stdbtn btn_black" onclick="history.back()">返回上一页</button>
						&nbsp;
						<button onclick="" class="stdbtn btn_orange">返回个人中心</button>
					</div>
				</div>
				<div id="compose" class="subcontent" style="display: none">&nbsp;</div>
			</div>

		</div>
	</div>
</body>
</html>

