<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
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
<c:if test="${identity ne 'admin'}">
<jsp:include page="banner.jsp"></jsp:include>
<div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            搜索结果
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#PosterManage" data-toggle="tab">帖子管理</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="PosterManage">
                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                搜索结果列表
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>序号</th>
                                                                <th>帖子标题</th>
                                                                <th>所在板块</th>
                                                                <th>发帖用户</th>
                                                                <th>点击数</th>
                                                                <th>发帖时间</th>
                                                                <th>帖子内容</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="poster" items="${posters}">
                                                                <tr>
                                                                    <td><c:out value="${poster.posterID}"/></td>
                                                                    <td><c:out value="${poster.posterTitle}"/></td>
                                                                    <td><c:out value="${poster.boardID}"/></td>
                                                                    <td><c:out value="${poster.userID}"/></td>
                                                                    <td><c:out value="${poster.counter}"/></td>
                                                                    <td><c:out value="${poster.posterTime}"/></td>
                                                                    <td><c:out value="${poster.posterContent}"/></td>
                                                               </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

<jsp:include page="footer.jsp"></jsp:include>
</c:if>
<c:if test="${identity eq 'admin'}">
<jsp:include page="header.jsp"></jsp:include>
<div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            管理平台
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#PosterManage" data-toggle="tab">帖子管理</a>
                                </li>
                                <li class=""><a href="#UserManage" data-toggle="tab">用户管理</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="PosterManage">
                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                帖子列表
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>序号</th>
                                                                <th>帖子标题</th>
                                                                <th>所在板块</th>
                                                                <th>发帖用户</th>
                                                                <th>点击数</th>
                                                                <th>发帖时间</th>
                                                                <th>帖子内容</th>
                                                                <th>编辑</th>
                                                                <th>置顶</th>
                                                                <th>删除</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="poster" items="${posters}">
                                                                <tr>
                                                                    <td><c:out value="${poster.posterID}"/></td>
                                                                    <td><c:out value="${poster.posterTitle}"/></td>
                                                                    <td><c:out value="${poster.boardID}"/></td>
                                                                    <td><c:out value="${poster.userID}"/></td>
                                                                    <td><c:out value="${poster.counter}"/></td>
                                                                    <td><c:out value="${poster.posterTime}"/></td>
                                                                    <td><c:out value="${poster.posterContent}"/></td>
                                                                    <td><a href="EditPoster?posterid=${poster.posterID}" class="btn btn-info">编辑</a></td>
                                                                    <td><a href="SetTop?posterid=${poster.posterID}" class="btn btn-primary">置顶</a></td>
                                                                    <td><a href="DeletePoster?posterid=${poster.posterID}" class="btn btn-danger">删除</a></td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="UserManage">
                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                            	<div class="row">
	                                            	<div class="col-md-4 col-sm-4">
	                                            		用户列表
	                                            	</div>
	                                                <div class="col-md-4 col-sm-4">
	                                            	
	                                            	</div>
	                                            	<div class="col-md-4 col-sm-4">
	                                            		<a href="adduser.jsp" class="btn btn-success">添加新用户</a>
	                                            	</div>
	                                            </div>
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                                <th>ID</th>
                                                                <th>用户名</th>
                                                                <th>密码</th>
                                                                <th>加/解锁</th>
                                                                <th>删除</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="user" items="${users}">
                                                                <tr>
                                                                    <td><c:out value="${user.userID}"/></td>
                                                                    <td><c:out value="${user.userName}"/></td>
                                                                    <td><c:out value="${user.userPassword}"/></td>
                                                                    <td>
                                                                    	<c:if test="${user.isLock==false}">
                                                                    		<a href="AddLock?userid=${user.userID}" class="btn btn-danger">加锁</a>
                                                                    	</c:if>
                                                                    	<c:if test="${user.isLock==true}">
                                                                    		<a href="DisLock?userid=${user.userID}" class="btn btn-success">解锁</a>
                                                                    	</c:if>
                                                                    </td>
                                                                    <td><a href="DeleteUser?userid=${user.userID}" class="btn btn-danger">删除</a></td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
<jsp:include page="footer.jsp"></jsp:include>
</c:if>
     <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>               
                
</body>
</html>