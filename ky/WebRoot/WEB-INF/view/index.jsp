<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="source/frontindex/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="source/frontindex/js/jquery.min.js"></script>
<script src="source/frontindex/js/script.js" type="text/javascript"></script>
<script src="source/frontindex/js/superfish.js"></script>
<script type="text/javascript">
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
									<a href="member/dashBoard.do"><span>${user.userName }（个人中心）</span></a>
									<a href="loginout.do"><span>退出登录</span></a>
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
							<div class="header_bottom_right_images">
								<div id="slideshow">
									<ul class="slides">
										<li><a href=""><canvas></canvas><img src="source/frontindex/images/banner4.jpg" alt="Marsa Alam underawter close up"></a></li>
										<li><a href=""><canvas></canvas><img src="source/frontindex/images/banner2.jpg" alt="Turrimetta Beach - Dawn"></a></li>
										<li><a href=""><canvas></canvas><img src="source/frontindex/images/banner3.jpg" alt="Power Station"></a></li>
										<li><a href=""><canvas></canvas><img src="source/frontindex/images/banner1.jpg" alt="Colors of Nature"></a></li>
									</ul>
									<span class="arrow previous"></span> <span class="arrow next"></span>
								</div>
							</div>
							<div class="header-para">
								<div class="categories">
									<div class="list-categories">
										<div class="first-list">
											<div class="div_2">
												<a href="carSearch.do?gearbox=1">自动档</a>
											</div>
											<div class="div_img">
												<img src="source/frontindex/images/car1.jpg" alt="Cars" title="Cars" width="60" height="39">
											</div>
											<div class="clear"></div>
										</div>
										<div class="first-list">
											<div class="div_2">
												<a href="carSearch.do?displacement=2">小排量</a>
											</div>
											<div class="div_img">
												<img src="source/frontindex/images/car2.jpg" alt="Cars" title="Cars" width="60" height="39">
											</div>
											<div class="clear"></div>
										</div>
										<div class="first-list">
											<div class="div_2">
												<a href="carSearch.do?gps=on">带导航</a>
											</div>
											<div class="div_img">
												<img src="source/frontindex/images/car3.jpg" alt="Cars" title="Cars" width="60" height="39">
											</div>
											<div class="clear"></div>
										</div>
										<div class="first-list">
											<div class="div_2">
												<a href="carSearch.do?maxprice=120">白菜价</a>
											</div>
											<div class="div_img">
												<img src="source/frontindex/images/car4.jpg" alt="Cars" title="Cars" width="60" height="39">
											</div>
											<div class="clear"></div>
										</div>
									</div>
									<div class="box-title">
										<h1>
			      							<span class="title-icon"></span><a href="beOwner.do">爱车出租</a>
										</h1>
									</div>
									<div>
										<p style="padding-top: 20px;font-size: 20px;">出租您的爱车:</p>
										<div class="clear"></div>
										<p style="padding-top: 20px;font-size: 20px;float: right;">方便他人，快乐赚钱。</p>
										<div class="clear"></div>
										<p style="padding-top: 20px;font-size: 15px;color:#D54F30">想要出租您的爱车，请点击“爱车出租”</p>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
