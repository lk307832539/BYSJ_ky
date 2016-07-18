<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%response.setContentType("text/html;charset=UTF-8");request.setCharacterEncoding("UTF-8");%>
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

<title>查看消息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		<div class="vernav iconmenu">
			<ul>
				<li class="current"><a href="manageblog.html" class="inbox">发送评价</a></li>
			</ul>
			<a class="togglemenu"></a> <br /> <br />
		</div>
		<!--leftmenu-->

		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">发送评价</h1>
				<span class="pagedesc">发送评价</span>

				<ul class="hornav">
					<li class="current"><a href="#inbox">发送评价</a></li>
				</ul>
			</div>
			<!--pageheader-->

			<div class="contentwrapper">
        	<div class="two_third">
                 <form action="appriseCar.do?orderid=${order.orderId }" method="post">
                    <div>
                        <textarea id="apprise" name="apprise" rows="15" cols="80" style="width: 80%" class="tinymce">
                        </textarea>
                    </div>
            
            
                    <br /><br />
                    <input type="submit" name="save" value="提交评价" />
                    <input type="reset" name="reset" value="重置评价" />
                 </form>
             </div>
        </div><!--contentwrapper-->
		</div>
		<!--centercontent-->


	</div>
	<!--bodywrapper-->

</body>
</html>

