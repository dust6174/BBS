<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to SouthDynasty BBS,Admin!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet">
     <!-- Google Fonts-->
   <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<c:if test="${param.update eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>更新成功！
	</div>
</c:if>
<c:if test="${param.settop eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>置顶成功！
	</div>
</c:if>
<c:if test="${param.deleteposter eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>删除成功！
	</div>
</c:if>
<c:if test="${param.addlock eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>加锁成功！
	</div>
</c:if>
<c:if test="${param.dislock eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>解锁成功！
	</div>
</c:if>
<c:if test="${param.adduser eq '1'}">
	<div class="alert alert-success">
		<strong>通知：</strong>添加用户成功！
	</div>
</c:if>
<c:if test="${param.register eq '1'}">
	<div class="alert alert-danger">
		<strong>警告：</strong>用户已存在，不可添加！
	</div>
</c:if>

<jsp:include page="ShowAll"></jsp:include>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>