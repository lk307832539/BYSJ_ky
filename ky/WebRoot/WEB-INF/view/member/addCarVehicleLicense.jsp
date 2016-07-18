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
				<li><a href="member/ownerCarManage.do" class="elements">车辆管理</a></li>
				<li><a href="member/addNewCarPage.do" class="elements">新建车辆</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->
		<div class="centercontent tables">
			<div class="pageheader notab">
				<h1 class="pagetitle">查看行驶证</h1>
				<span class="pagedesc">这里可以查看该车辆行驶证信息</span>

			</div>
			<!--pageheader-->

			<div id="basicform" class="subcontent">

				<div class="contenttitle2">
					<h3>查看行驶证</h3>
				</div>
				<!--contenttitle-->

				<form class="stdform" action="member/AddCarVehicleLicense.do?carid=${car.carId }" method="post">
					<p>
						<label>请输入号牌号码</label> <span class="field"> <input type="text" name="plateNo" class="smallinput" value="${vehicleLicense.plateNo }" /></span>
					</p>
					<p>
						<label>请输入车辆类型</label> <span class="field"> <input type="text" name="vehicleType" class="smallinput" value="${vehicleLicense.vehicleType }" /></span>
					</p>
					<p>
						<label>请输入所有人姓名</label> <span class="field"> <input type="text" name="owener" class="smallinput" value="${vehicleLicense.owener }" /></span>
					</p>
					<p>
						<label>请输入所有人住址</label> <span class="field"> <input type="text" name="address" class="smallinput" value="${vehicleLicense.address }" />
						</span>
					</p>
					<p>
						<label>请输入使用性质</label> <span class="field"><input type="text" name="useCharacter" class="smallinput" value="${vehicleLicense.useCharacter }" /> </span>
					</p>
					<p>
						<label>请输入品牌型号</label> <span class="field"><input type="text" name="carModel" class="smallinput" value="${vehicleLicense.model }" /> </span>
					</p>
					<p>
						<label>请输入车辆识别号</label> <span class="field"><input type="text" name="vin" class="smallinput" value="${vehicleLicense.vin }" /> </span>
					</p>
					<p>
						<label>请输入发动机号码</label> <span class="field"><input type="text" name="engineNo" class="smallinput" value="${vehicleLicense.engineNo }" /> </span>
					</p>
					<p>
						<label>请输入注册时间</label> <span class="field"> 
							<c:choose>
								<c:when test="${vehicleLicense.registerDate == null }">
									<input type="date" name="registerDate" class="smallinput" />
								</c:when>
								<c:otherwise>
									<input type="datetime" name="registerDate" class="smallinput" value="${vehicleLicense.registerDate }" />
								</c:otherwise>
							</c:choose>
						</span>
					</p>
					<p>
						<label>请输入发证日期</label> <span class="field"> 
							<c:choose>
								<c:when test="${vehicleLicense.lssueDate==null  }">
									<input type="date" name="lssueDate" class="smallinput" />
								</c:when>
								<c:otherwise>
									<input type="datetime" name="lssueDate" class="smallinput" value="${vehicleLicense.lssueDate}" />
								</c:otherwise>
							</c:choose>
						</span>
					</p>
					<p>
						<label>请上传行驶证主页照片</label> <span class="field"><input type="text" name="vehicleLicenseFirImg" class="smallinput" value="${vehicleLicense.vehicleLicenseFirImg }" /> </span>
					</p>
					<p>
						<label>请上传行驶证副页照片</label> <span class="field"><input type="text" name="vehicleLicenseSecImg" class="smallinput" value="${vehicleLicense.vehicleLicenseSecImg }" /> </span>
					</p>
					<br clear="all" /> <br />
					<p class="stdformbutton">
						<button class="submit radius2">确认提交</button>
						<input type="reset" class="reset radius2" value="重新填写" />
					</p>
					<c:choose>
						<c:when test="${user.isAdmin==true && vehicleLicense.isChecked==false}">
							<h4 style="margin-left: 220px">请管理员审核并且选择车辆是否通过审核</h4>
							<p style="margin-left: 220px">
								<a type="button" class="stdbtn btn_lime" href="vehicleLicenseVerifyPass.do?carid=${car.carId }">审核通过</a> <a type="button" class="stdbtn" href="vehicleLicenseVerifyDisPass.do?carid=${car.carId }">审核不通过</a>
							</p>
						</c:when>
					</c:choose>
				</form>
				<br />
			</div>
			<!-- centercontent -->
		</div>
		<!--bodywrapper-->
</body>
</html>
