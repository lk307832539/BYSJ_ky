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
				<h1 class="pagetitle">新建车辆</h1>
				<span class="pagedesc">这里可以增加一辆新的车辆</span>

			</div>
			<!--pageheader-->

			<div id="basicform" class="subcontent">

				<div class="contenttitle2">
					<h3>新建车辆</h3>
				</div>
				<!--contenttitle-->

				<form class="stdform" action="member/addNewCarAct.do" method="post">
					<p>
						<label>请选择汽车品牌</label> <span class="field"> <select name="brandid" id="brandid" class="uniformselect">
								<option value="">请选择汽车品牌</option>
								<c:forEach items="${brandlist }" var="brand">
									<option value="${brand.brandId }">${brand.brandName }</option>
								</c:forEach>
						</select></span>
					</p>
					<script type="text/javascript">
						(function($) {
							$("#brandid").change(function() {
								getSeries($("#brandid").val());
							});
						})(jQuery);
						function getSeries(brandid) {
							jQuery.ajax({
								url : "member/getCarSerieses.do?brandid="
										+ brandid,
								type : "GET",
								success : function(data) {
									jQuery.each(data, function(i, item) {
										jQuery(
												"<option value='" + item.seriesId + "'>"
														+ item.seriesName
														+ "</option><br>")
												.appendTo(jQuery('#seriesid'));
									});
								}
							});
						}
					</script>
					<p>
						<label>请选择汽车系列</label> <span class="field"> <select name="seriesid" id="seriesid" class="uniformselect">
								<option value="">请选择汽车系列</option>
						</select></span>
					</p>
					<p>
						<label>请选择汽车类型</label> <span class="field"> <select name="levelid" class="uniformselect">
								<option value="">请选择汽车类型</option>
								<c:forEach items="${levellise }" var="level">
									<option value="${level.levelId }">${level.levelName }</option>
								</c:forEach>
						</select></span>
					</p>
					<p>
						<label>请输入车龄</label> <span class="field"><input type="text" name="carage" class="smallinput" value="0" /></span>
					</p>
					<p>
						<label>请输入座位数</label> <span class="field"><input type="text" name="seatnum" class="smallinput" value="0" /></span>
					</p>
					<p>
						<label>请输入排量</label> <span class="field"><input type="text" name="displacement" class="smallinput" value="0" /> </span><small class="desc">例如1600,2400</small>
					</p>
					<p>
						<label>请输入安全气囊</label> <span class="field"><input type="text" name="airbag" class="smallinput" value="0" /> </span>
					</p>
					<p>
						<label>请选择变速器</label> <span class="field"> <select name="gearbox" class="uniformselect">
								<option value="">请选择变速器</option>
								<option value="1">自动档</option>
								<option value="2">手动档</option>
						</select></span>
					</p>
					<p>
						<label>请根据情况选择</label> <span class="formwrapper"> <input type="checkbox" name="GPS" />是否有GPS<br /> <input type="checkbox" name="DVD" />是否有DVD<br /> <input type="checkbox" name="reverseradar" />是否有倒车雷达<br />
						</span>
					</p>
					<p>
						<label>请输入出租价格</label> <span class="field"><input type="text" placeholder="元/天" name="price" class="smallinput" />
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
