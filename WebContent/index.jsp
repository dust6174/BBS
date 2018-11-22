<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="SimpleTag" prefix="stag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
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
<style>
body{
   background:url(./images/7331506_11.jpg)  no-repeat center center;
   background-size:100% 100%;
   background-attachment:fixed;
}
</style>
</head>
<body class="user-select">
	<jsp:include page="banner.jsp"></jsp:include>
	<%
		String key = "7";
		if(request.getParameter("keys")!=null)
		key = request.getParameter("keys");
	%>
	<stag:ShowPoster key="<%=key%>"></stag:ShowPoster>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.ias.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
