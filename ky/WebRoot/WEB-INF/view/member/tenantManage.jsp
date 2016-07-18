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
				<h1 class="pagetitle">租客管理</h1>
				<span class="pagedesc">这里可以查看租客信息</span>

			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div class="contenttitle2">
					<h3>租客总览</h3>
				</div>
				<!--contenttitle-->

				<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablequick">
					<colgroup>
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0">用户名</th>
							<th class="head1">Email</th>
							<th class="head0">注册时间</th>
							<th class="head1">真实姓名</th>
							<th class="head0">电话号码</th>
							<th class="head1">是否通过审核</th>
							<th class="head0">详细信息</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carTenantList }" var="carTenant">
							<tr>
								<td class="con0">${carTenant.user.userName }</td>
								<td class="con1">${carTenant.user.email }</td>
								<td class="con0">${carTenant.user.registerTime }</td>
								<td class="center">${carTenant.realName }</td>
								<td class="center">${carTenant.phone }</td>
								<td class="center">${carTenant.isChecked }</td>
								<td class="center"><a href="member/carTenantDetail.do?tenantid=${carTenant.tenantId }" class="toggle">查看详情</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--contentwrapper-->

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->
</body>
</html>