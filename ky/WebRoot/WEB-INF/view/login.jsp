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
<link href="source/login/css/loginstyle.css" rel='stylesheet' type='text/css' />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
</script>
<script src="source/login/js/jquery.min.js"></script>
<script src="source/login/js/easyResponsiveTabs.js" type="text/javascript"></script>
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

<body>
	<div class="main">
		<h1>康云租赁</h1>
		<h2>欢迎您</h2>
		<h3 style="color: red;">${massage}</h3>
		<div class="sap_tabs">
			<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
				<ul class="resp-tabs-list">
					<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>注册</span></li>
					<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>登录</span></li>
					<div class="clear"></div>
				</ul>
				<!---->
				<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
						<div class="facts">
							<!--login1-->
							<div class="register">
								<form action="simpleRegist.do" method="post">
									<input placeholder="请输入昵称" name="username" type="text" required=""> 
									<input placeholder="请输入注册邮箱" name="email" type="text" required=""> 
									<input placeholder="请输入密码" name="password" type="password" required=""> 
									<input placeholder="请再次输入密码" name="repassword" type="password" required="">
									<div class="sign-up">
										<input type="submit" value="注册" />
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
						<div class="facts">
							<div class="register">
								<form action="login.do" method="post">
									<input placeholder="请输入用户名" name="username" class="mail" type="text" required="">
									<input placeholder="请输入密码" name="password" class="lock" type="password" required="">
									<div class="sign-up">
										<input type="submit" value="提交" />
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
