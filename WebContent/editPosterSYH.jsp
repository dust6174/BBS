<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="SimpleTag" prefix="stag"%>
<%@ page import="entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>show</title>
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
<body class="user-select single">
	<jsp:include page="banner.jsp"></jsp:include>
	<section class="container">
	<div class="content-wrap">
		<div class="content">
		<br><br><br><br>
			<div id="respond">
				<form id="comment-form" name="comment-form" action="EditMyPoster"
					method="POST">
					<div class="comment">
					<input type="hidden" name="posterid" value="${param.id }">
						<input name="postertitle" id="" class="form-control" size="22" value="${param.title}"
								maxlength="15" type="text">
								<br>
						<div class="comment-box">
							<textarea name="postercontent" 
								id="comment-textarea" cols="100%" rows="3" tabindex="3" >${param.content}</textarea>
							<div class="comment-ctrl">
								<div class="comment-prompt" style="display: none;">
									<i class="fa fa-spin fa-circle-o-notch"></i> <span
										class="comment-prompt-text">正在提交中...请稍后</span>
								</div>
								<div class="comment-success" style="display: none;">
									<i class="fa fa-check"></i> <span class="comment-prompt-text">提交成功...</span>
								</div>
								<button type="submit" name="comment-submit" id="comment-submit"
									tabindex="4">重新发布</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.ias.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
