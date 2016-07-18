<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="topheader">
	<div class="left">
		<h1 class="logo">
			康云<span>租赁</span>
		</h1>
		<span class="slogan">个人中心</span> <br clear="all" />
	</div>
	<!--left-->

	<div class="right">
		<div class="userinfo">
			<img src="source/member/images/thumbs/avatar.png" alt="" /> <span>${user.userName }</span>
		</div>
		<!--userinfo-->

		<div class="userinfodrop">
			<div class="avatar">
				<a href=""><img src="source/member/images/thumbs/avatarbig.png" alt="" /></a>
			</div>
			<!--avatar-->
			<div class="userdata">
				<h4>${user.userName }</h4>
				<ul>
					<li><a href="">返回前台</a></li>
					<li><a href="loginout.do">退出登录</a></li>
				</ul>
			</div>
			<!--userdata-->
		</div>
		<!--userinfodrop-->
	</div>
	<!--right-->
</div>
<!--topheader-->
<div class="header">
	<ul class="headermenu">
		<li><a href="member/dashBoard.do"><span class="icon icon-flatscreen"></span>首页</a></li>
		<c:choose>
			<c:when test="${user.isOwner==true }">
				<li><a href="member/ownerCarManage.do"><span class="icon icon-pencil"></span>车辆管理</a></li>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${user.isTenant==true }">
				<li><a href="member/tenantCarManage.do"><span class="icon icon-chart"></span>租车管理</a></li>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${user.isAdmin==true }">
				<li><a href="member/carOwnerList.do"><span class="icon icon-pencil"></span>用户管理</a></li>
			</c:when>
		</c:choose>
		<li><a href="member/messageList.do"><span class="icon icon-message"></span>查看消息</a></li>
	</ul>
	<!--headerwidget-->
</div>
<!--header-->