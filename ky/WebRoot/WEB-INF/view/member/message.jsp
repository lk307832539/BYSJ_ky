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
					<li class="current"><a href="#inbox">收件箱</a></li>
				</ul>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div id="inbox" class="subcontent">
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable mailinbox">
						<colgroup>
							<col class="con1" width="20%" />
							<col class="con0" width="63%" />
							<col class="con1" width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th class="head1">信息类型</th>
								<th class="head0">信息内容</th>
								<th class="head0">发信时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${meslist}" var="entry">
								<c:choose>
									<c:when test="${entry.statue==0}">
										<tr class="unread">
									</c:when>
									<c:otherwise>
										<tr>
									</c:otherwise>
								</c:choose>
								<td style="max-height: 25px;">${entry.massageContents.type}</td>
								<td style="max-height: 25px;"><a href="member/messageDetail.do?messageid=${entry.messageId}" class="title">${entry.massageContents.massageContent}</a></td>
								<td class="date" style="max-height: 25px;">${entry.massageContents.postDate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="compose" class="subcontent" style="display: none">&nbsp;</div>
			</div>
			<!--contentwrapper-->
		</div>
		<!--centercontent-->


	</div>
	<!--bodywrapper-->

</body>
</html>

