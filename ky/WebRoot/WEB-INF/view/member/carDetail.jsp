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
				<li><a href="member/ownerCarManage.do" class="elements">车辆管理</a></li>
				<li><a href="member/addNewCarPage.do" class="elements">新建车辆</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">
			<div class="pageheader notab">
				<h1 class="pagetitle">车辆详情</h1>
				<span class="pagedesc">查看和修改车辆的具体信息</span>

			</div>
			<!--pageheader-->

			<div id="basicform" class="subcontent">

				<div class="contenttitle2">
					<h3>车辆详情</h3>
				</div>
				<!--contenttitle-->
				<c:choose>
					<c:when test="${car.vehicleLicenses == null }">
						<h4 style="margin-left: 220px">
							<a href="member/CarVehicleLicensePage.do?carid=${car.carId }" style="color: red">尚未填写行驶证信息，请点击填写</a>
						</h4>
					</c:when>
					<c:otherwise>
						<h4 style="margin-left: 220px">
							<a href="member/CarVehicleLicensePage.do?carid=${car.carId }">点击查看或修改行驶证信息</a>
						</h4>
					</c:otherwise>
				</c:choose>
				<form class="stdform" action="" method="post">
					<p>
						<label>请选择汽车品牌</label> <span class="field"> <select name="brandid" class="uniformselect">
								<option value="${car.carBrand.brandId }">${car.carBrand.brandName }</option>
						</select></span>
					</p>
					<p>
						<label>请选择汽车系列</label> <span class="field"> <select name="seriesid" class="uniformselect">
								<option value="${car.carSeries.seriesId }">${car.carSeries.seriesName }</option>
						</select></span>
					</p>
					<p>
						<label>请选择汽车类型</label> <span class="field"> <select name="levelid" class="uniformselect">
								<option value="${car.carLevel.levelId}">${car.carLevel.levelName }</option>
						</select></span>
					</p>
					<p>
						<label>请输入车龄</label> <span class="field"><input type="text" name="carage" class="smallinput" value="${car.carAge }" /></span>
					</p>
					<p>
						<label>请输入座位数</label> <span class="field"><input type="text" name="seatnum" class="smallinput" value="${car.seatNum }" /></span>
					</p>
					<p>
						<label>请输入排量</label> <span class="field"><input type="text" name="displacement" class="smallinput" value="${car.displacement }" /> </span><small class="desc">例如1600,2400</small>
					</p>
					<p>
						<label>请输入安全气囊</label> <span class="field"><input type="text" name="displacement" class="smallinput" value="${car.airBag }" /> </span>
					</p>
					<p>
						<label>请选择变速器</label> <span class="field"> <select name="gearbox" class="uniformselect">
								<c:choose>
									<c:when test="${car.gearbox==1 }">
										<option value="1">自动档</option>
									</c:when>
									<c:otherwise>
										<option value="2">手动档</option>
									</c:otherwise>
								</c:choose>
						</select></span>
					</p>
					<p>
						<label>请根据情况选择</label> <span class="formwrapper"> <c:choose>
								<c:when test="${car.gps==true }">
									<input type="checkbox" id="GPS" name="GPS" checked="checked" />是否有GPS<br />
								</c:when>
								<c:otherwise>
									<input type="checkbox" id="GPS" name="GPS" />是否有GPS<br />
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${car.dvd==true }">
									<input type="checkbox" id="DVD" name="DVD" checked="checked" />是否有DVD<br />
								</c:when>
								<c:otherwise>
									<input type="checkbox" id="DVD" name="DVD" />是否有DVD<br />
								</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${car.reverseRadar==true }">
									<input type="checkbox" id="reverseradar" name="reverseradar" checked="checked" />是否有倒车雷达<br />
								</c:when>
								<c:otherwise>
									<input type="checkbox" id="reverseradar" name="reverseradar" />是否有倒车雷达<br />
								</c:otherwise>
							</c:choose>
						</span>

					</p>
					<p>
						<label>请输入出租价格</label> <span class="field"><input type="text" placeholder="元/天" name="price" class="smallinput" value="${car.price }" />
					</p>
					<br clear="all" /> <br />

					<p class="stdformbutton">
						<button class="submit radius2">确认提交</button>
						<input type="reset" class="reset radius2" value="重新填写" />
					</p>
				</form>
				<c:choose>
					<c:when test="${user.isAdmin==true && car.isChecked==false}">
						<c:choose>
							<c:when test="${car.vehicleLicenses==null }">
								<h3 style="margin-left: 220px">等待车主输入行驶证信息后进行审核。</h3>
							</c:when>
							<c:when test="${car.vehicleLicenses.isChecked==false }">
								<h3 style="margin-left: 220px">请先审核车辆的行驶证信息。</h3>
							</c:when>
							<c:otherwise>
								<h3 style="margin-left: 220px">请管理员审核并且选择车辆是否通过审核</h3>
								<p style="margin-left: 220px">
									<a type="button" class="stdbtn btn_lime" href="carVerifyPass.do?carid=${car.carId }">审核通过</a>
									<a type="button" class="stdbtn" href="carVerifyDisPass?carid=${car.carId }">审核不通过</a>
								</p>
							</c:otherwise>
						</c:choose>

					</c:when>
				</c:choose>
				<br />
			</div>
			<!-- centercontent -->


		</div>
		<!--bodywrapper-->
</body>
</html>
