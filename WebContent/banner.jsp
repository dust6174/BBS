<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 从session中获取参数:islogin,identity,id,name,islock(user)显示欢迎信息、登录登出按钮、论坛图标、搜索框等 -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="row">
	<div class="col-md-4 col-sm-4">
		<c:if test="${adminname!=null}">
			<a href="adminhomepage.jsp">
			<img src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~"/>
			</a>
		</c:if>
		<c:if test="${adminname==null}">
			<a href="homepage.jsp">
			<img src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~"/>
			</a>
		</c:if>
	</div>
	<div class="col-md-4 col-sm-4">
		<c:if test="${islogin==true}">
			<c:if test="${username!=null}">
				<p>您好!${username}</p>
			</c:if>
			<c:if test="${adminname!=null}">
				<p>您好!管理员${adminname}</p>
			</c:if>
		</c:if>
		<c:if test="${(username==null)&&(adminname==null)}">
			<p>您好，游客</p>
		</c:if>
	</div>
</div>

</body>
</html>