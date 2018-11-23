<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 从session中获取参数:islogin,identity,id,name,islock(user)显示欢迎信息、登录登出按钮、论坛图标、搜索框等 -->
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nprogress.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon.png">
<link rel="shortcut icon" href="images/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/nprogress.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
</head>
<body>
<header class="header"> <nav class="navbar navbar-default"
		id="navbar">
	<div class="container">
		<div class="header-topbar hidden-xs link-border">
			<c:if test="${islogin==true}">
				<ul class="site-nav topmenu">
					<c:if test="${(islock==false)&&(identity eq 'user')}">
					<li><a href="addPoster.jsp">发帖</a></li>
					</c:if>
					<li><a href="Logout">登出</a></li>
					<li><a href="editmyinfo.jsp?username=${username}" rel="nofollow">${username}</a></li>
					<c:if test="${identity eq 'user'}">
					<li><a href="myPoster.jsp" title="RSS订阅"> <i class="fa fa-rss"> </i>
							我的发布
					</a></li>
					</c:if>
				</ul>
			</c:if>
			<c:if test="${islogin!=true}">
				<ul class="site-nav topmenu">
					<li><a href="login.jsp" class="btn btn-default">登录</a></li>
					<li>	OR</li>
					<li><a href="register.jsp" class="btn btn-default">注册</a></li>
				
					<li><a href="adminlogin.jsp" class="btn btn-default" title="管理员登录">管理员登录</a></li>
				</ul>
			</c:if>
			
		</div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#header-navbar"
				aria-expanded="false">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<h1 class="logo hvr-bounce-in">
					<a href="homepage.jsp" title="南朝论坛">
						<img src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~">
					</a>
			</h1>
			
		</div>
		<div class="collapse navbar-collapse" id="header-navbar">
					<form class="navbar-form" action="Search" method="post">
					  <div class="input-group">
							<input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" autocomplete="off">
							<span class="input-group-btn">
								<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
							</span> 
						</div>
					</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a data-cont="最新" title="最新" href="Board?board=1">最新</a></li>
				<li><a data-cont="自然科学" title="自然科学" href="Board?board=2">自然科学</a></li>
				<li><a data-cont="影评书刊" title="影评书刊" href="Board?board=3">影评书刊</a></li>
				<li><a data-cont="近代战争" title="近代战争" href="Board?board=4">近代战争</a></li>
				<li><a data-cont="古代战争" title="古代战争" href="Board?board=5">古代战争</a></li>
				<li><a data-cont="南朝明研室" title="南朝明研室" href="Board?board=6">南朝明研室</a></li>
				<li><a data-cont="留言板" title="留言板" href="Board?board=7">留言板</a></li>
			</ul>
		</div>
	</div>
	</nav> </header>
</body>
</html>