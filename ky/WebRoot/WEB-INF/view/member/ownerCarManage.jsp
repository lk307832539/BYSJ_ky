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

<title>汽车管理</title>
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
				<li><a href="member/ownerCarManage.do" class="elements">车辆管理</a></li>
				<li><a href="member/addNewCarPage.do" class="elements">新建车辆</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">

			<div class="pageheader notab">
				<h1 class="pagetitle">车辆管理</h1>
				<span class="pagedesc">这里可以查看您的车辆以及车辆状态</span>

			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div class="contenttitle2">
					<h3>车辆总览</h3>
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
							<th class="head0">品牌</th>
							<th class="head1">系列</th>
							<th class="head0">价格</th>
							<th class="head1">是否已经被租赁</th>
							<th class="head0">是否填写行驶证信息</th>
							<th class="head1">是否通过审核</th>
							<th class="head0">详细信息</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="car">
							<tr>
								<td class="con0">${car.carBrand.brandName }</td>
								<td class="con1">${car.carSeries.seriesName }</td>
								<td class="con0">${car.price }</td>
								<td class="center">${car.isSelled }</td>
								<td class="center">${car.isVehicleLicense }</td>
								<td class="center">${car.isChecked }</td>
								<td class="center"><a href="member/CarDetail.do?carid=${car.carId }" class="toggle">查看详情</a>
								<c:choose>
								<c:when test="${car.isSelled == true }">
								<a href="OrderFinish.do?carid=${car.carId }">完成租赁</a>
								</c:when>
								</c:choose>
								</td>
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
