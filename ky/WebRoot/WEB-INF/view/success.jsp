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
						已经通知车主 查看您的订购信息，我们会通过站内信将结果通知您，请关注你的站内信。<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

    	
