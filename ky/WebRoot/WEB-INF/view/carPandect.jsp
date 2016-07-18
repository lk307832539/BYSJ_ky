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

<title>康云CONTENT</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="source/frontindex/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="source/frontindex/js/jquery.min.js"></script>
<script src="source/frontindex/js/script.js" type="text/javascript"></script>
<script src="source/frontindex/js/superfish.js"></script>
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
								<li><a href="indexRedirect.do">主页</a></li>
								<li class="active"><a href="carPandectRedirect.do">租车</a></li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
					<div class="banner-top">
						<div class="header-bottom">
							<form action="carSearch.do">
								<div class="searchCar">
									<div style="float: left;">
										<label class="">价格</label> <input type="text" placeholder="最低价格" name="minprice">-<input placeholder="最高价格" type="text" name="maxprice">
									</div>
									<div style="float: left;">
										<label class="">变速器</label> 
										<select name="gearbox">
											<option value="0">不限</option>
											<option value="1">自动档</option>
											<option value="2">手动档</option>
										</select>
									</div>
									<div class="clear"></div>
									<div style="float: left;">
										<label class="">排量</label> 
										<select name="displacement">
											<option value="0">不限</option>
											<option value="1">1.5L及以下</option>
											<option value="2">1.6L-2.0L或1.6T及以下</option>
											<option value="3">2.1L-2.5L或1.7T-2.0T</option>
											<option value="4">2.6L或2.1T及以上</option>
										</select>
									</div>

									<div>
										<ul class="inline clearfix"">
											<li class="compact">
												<div class="" style="float: left;">
													<label class="">配置</label> <input class="" type="checkbox" id="in_gps" name="gps"> <span class="">导航仪</span> <input class="" type="checkbox" id="in_dvd" name="dvd"> <span class="">DVD</span>
												</div>
											</li>
											<div class="clear"></div>
											<!-- <li class="compact">
												<div class="" id="in_classes">
													<label class="">级别</label> <input id="1" class="" type="checkbox" value="1"><span class="">经济型轿车</span> <input id="2" class="" type="checkbox" value="2"><span class="">家用型轿车</span> <input id="3" class="" type="checkbox" value="3"><span class="">商务型轿车</span> <input id="4" class="" type="checkbox" value="4"> <span class="">豪华型轿车</span> <input id="5" class="" type="checkbox" value="8"> <span class="">SUV</span> <input id="6" class="" type="checkbox" value="10"> <span class="">6到15座商务车</span>
												</div>
											</li> -->
										</ul>
									</div>
								</div>
								<div style="float: right;">
									<input type="submit" value="提交">
								</div>
							</form>
							<div class="clear"></div>
						</div>

						<div class="content-top">
							<div class="box_wrapper">
								<h1></h1>
							</div>

							<div class="text">
								<c:forEach items="${carlist }" var="car">
									<div class="grid_1_of_3 images_1_of_3">
										<div class="grid_1">
											<a href="single.do?carid=${car.carId }"><img src="source/frontindex/images/pic15.jpg" title="continue reading" alt=""></a>
											<div class="grid_desc">
												<p class="title">${car.carBrand.brandName }${car.carSeries.seriesName }</p>

												<div class="price" style="height: 19px;">
													<span style="color: black;">￥${car.price }</span>
												</div>
												<div class="cart-button">
													<div class="cart">
														<a class="button" href="single.do?carid=${car.carId }"> 详情 </a>
													</div>
													<div class="clear"></div>
												</div>
											</div>
										</div>
										<div class="clear"></div>
									</div>
								</c:forEach>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="paging">
						<ul>
							<li><a href="#" target="_parent">Previous</a></li>
							<li><a href="#" target="_parent">1</a></li>
							<li><a href="#" target="_parent">2</a></li>
							<li><a href="#" target="_parent">3</a></li>
							<li><a href="#" target="_parent">4</a></li>
							<li><a href="#" target="_parent">5</a></li>
							<li><a href="#" target="_parent">6</a></li>
							<li><a href="#" target="_parent">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
