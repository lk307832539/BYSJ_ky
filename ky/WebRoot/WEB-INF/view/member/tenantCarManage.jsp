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
				<li><a href="member/tenantCarManage.do" class="elements">租赁管理</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">

			<div class="pageheader notab">
				<h1 class="pagetitle">租赁管理</h1>
				<span class="pagedesc">这里可以查看您的所有租赁信息</span>

			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div class="contenttitle2">
					<h3>租赁信息</h3>
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
					<thead>
						<tr>
							<th class="head0">订单编号</th>
							<th class="head1">价格</th>
							<th class="head0">订单状态</th>
							<th class="head1">租赁汽车品牌</th>
							<th class="head0">租赁汽车系列</th>
							<th class="head1">汽车详细信息</th>
						</tr>
					</thead>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="order">
							<tr>
								<td class="con0">${order.code }</td>
								<td class="con1">${order.rentalPrice }</td>
								<td class="con0"><c:choose>
										<c:when test="${order.status==1 }">
								订单已取消
								</c:when>
										<c:when test="${order.status==2 }">
								订单进行中
								</c:when>
										<c:when test="${order.status==3 }">
								订单已完成
								</c:when>
										<c:when test="${order.status==4 }">
								订单已评价
								</c:when>
										<c:otherwise>订单待处理</c:otherwise>
									</c:choose></td>
								<td class="center">${order.car.carBrand.brandName }</td>
								<td class="center">${order.car.carSeries.seriesName }</td>
								<td class="center"><a href="single.do?carid=${order.car.carId }" class="toggle">查看详情</a></td>
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
