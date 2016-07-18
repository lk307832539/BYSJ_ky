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

<title>康云HOME</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="keywords" content="Auto Show Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<meta http-equiv="description" content="This is my page">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="source/frontindex/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="source/frontindex/js/jquery.min.js"></script>
<script src="source/frontindex/js/script.js" type="text/javascript"></script>
<script src="source/frontindex/js/superfish.js"></script>
<!-- 页面js -->
<link href="source/single/css/style.css" rel='stylesheet' type='text/css' />
<link href="source/single/css/component.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<script type="text/javascript" src="source/single/js/jquery-1.11.1.min.js"></script>
<script src="source/single/js/bootstrap.min.js"></script>
<!-- start menu -->
<script src="source/single/js/imagezoom.js"></script>
<script defer src="source/single/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="source/single/css/flexslider.css" type="text/css" media="screen" />
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>

<script src="source/single/js/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>
</head>
</head>
</script>
</head>

<body>
	<div class="header-bg">
		<div class="wrap">
			<div class="h-bg">
				<div class="total">
					<div class="header">
						<div class="header-bot">
							<div class="logo">
								<a href="indexRedirect.do"><img src="source/frontindex/images/logo.png" alt="" /></a>
							</div>
							<c:choose>
								<c:when test="${user==null}">
									<div class="search">
										<a href="logingoto.do"><span>登录/注册</span></a>
									</div>
								</c:when>
								<c:otherwise>
									<div class="search">
										<a href="member/dashBoard.do"><span>${user.userName }（个人中心）</span></a> <a href="loginout.do"><span>退出登录</span></a>
									</div>
								</c:otherwise>
							</c:choose>
							<div class="clear"></div>
						</div>
					</div>
					<div class="menu">
						<div class="top-nav">
							<ul>
								<li class="active"><a href="indexRedirect.do">主页</a></li>
								<li><a href="carPandectRedirect.do">租车</a></li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
					<div class="banner-top">
						<div class="header-bottom">
							<div class="col-md-9 single_top">
								<div class="single_left">
									<div class="labout span_1_of_a1">
										<div class="flexslider">
											<div class="flex-viewport" style="overflow: hidden; position: relative;">
												<ul class="slides" style="width: 1200%; transition-duration: 0s; transform: translate3d(-867px, 0px, 0px);">
													<li data-thumb="source/single/images/s1.jpg" class="" style="width: 289px; float: left; display: block;">
														<div class="thumb-image">
															<img src="source/single/images/s1.jpg" data-imagezoom="true" class="img-responsive" draggable="false">
														</div>
													</li>
													<li data-thumb="source/single/images/s2.jpg" class="" style="width: 289px; float: left; display: block;">
														<div class="thumb-image">
															<img src="source/single/images/s2.jpg" data-imagezoom="true" class="img-responsive" draggable="false">
														</div>
													</li>
													<li data-thumb="source/single/images/s3.jpg" class="flex-active-slide" style="width: 289px; float: left; display: block;">
														<div class="thumb-image">
															<img src="source/single/images/s3.jpg" data-imagezoom="true" class="img-responsive" draggable="false">
														</div>
													</li>
													<li data-thumb="source/single/images/s4.jpg" class="" style="width: 289px; float: left; display: block;">
														<div class="thumb-image">
															<img src="source/single/images/s4.jpg" data-imagezoom="true" class="img-responsive" draggable="false">
														</div>
													</li>
												</ul>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="cont1 span_2_of_a1">
										<h1>${car.carBrand.brandName }${car.carSeries.seriesName }</h1>
										<p class="availability">
											尚未租赁: <span class="color">有货</span>
										</p>
										<div class="price_single">
											<span style="color: black;">￥${car.price }</span>
										</div>
										<h2 class="quick">速览</h2>


										<p class="quick_desc">车龄：${car.carAge }</p>
										<p class="quick_desc">座位数：${car.seatNum }</p>
										<p class="quick_desc">安全气囊：${car.airBag }</p>
										<p class="quick_desc">变速器：
										<c:choose><c:when test="${car.gearbox==1 }">自动档</c:when>
										<c:otherwise>手动档</c:otherwise></c:choose>
										</p>
										<c:choose>
											<c:when test="${car.gps==true }">
												<p class="quick_desc">有GPS</p>
											</c:when>
										</c:choose>
										<c:choose>
											<c:when test="${car.dvd==true }">
												<p class="quick_desc">有DVD</p>
											</c:when>
										</c:choose>
										<c:choose>
											<c:when test="${car.reverseRadar==true }">
												<p class="quick_desc">有倒车雷达</p>
											</c:when>
										</c:choose>
										<a href="reserveCarAct.do?carId=${car.carId }" title="Online Reservation" class="btn btn-primary btn-normal btn-inline ">确认租赁</a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix" style="clear: both;"></div>
								<div class="sap_tabs">
									<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
										<ul class="resp-tabs-list">
											<li class="resp-tab-item resp-tab-active" aria-controls="tab_item-0" role="tab"><span>车辆详情</span></li>
											<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>注意事项</span></li>
											<li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>留言板</span></li>
											<div class="clear"></div>
										</ul>
										<div class="resp-tabs-container">
											<h2 class="resp-accordion resp-tab-active" role="tab" aria-controls="tab_item-0">
												<span class="resp-arrow"></span>车辆详情
											</h2>
											<div class="tab-1 resp-tab-content resp-tab-content-active" aria-labelledby="tab_item-0" style="display:block">
												<div class="facts">
													<ul class="tab_list">
														<li>车辆描述【提示：请携带租客本人身份证、驾驶证当面交车】</li>
														<li>租客请携带身份证，行驶证来取车</li>
														<li>条件限制</li>
														<li>租客驾龄要求：至少1年及以上</li>
													</ul>
												</div>
											</div>
											<h2 class="resp-accordion" role="tab" aria-controls="tab_item-1">
												<span class="resp-arrow"></span>注意事项
											</h2>
											<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
												<div class="facts">
													<ul class="tab_list">
														<li>请租客确定车主信息，与车主进行详细的商谈</li>
														<li>租车时请查看车辆状态以及，车辆的行驶证信息</li>
													</ul>
												</div>
											</div>
											<h2 class="resp-accordion" role="tab" aria-controls="tab_item-2">
												<span class="resp-arrow"></span>留言板
											</h2>
											<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
												<c:forEach items="${massageBoardList }" var="massageBoard">
													<ul class="tab_list">
														<li>发表者：${massageBoard.user.userName }</li>
														<li>发表时间：${massageBoard.sendTime }</li>
														<li>发表内容：${massageBoard.content }</li>
														<li></li>
													</ul>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>
