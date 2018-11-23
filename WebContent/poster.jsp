<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="SimpleTag" prefix="stag"%>
	<%@ page import="entity.*" %>
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
   background-size:100% 100%;"
   background-attachment:fixed;
}
</style>
</head>
<body class="user-select single">
	<jsp:include page="banner.jsp"></jsp:include>
	<section class="container">
	<div class="content-wrap">
		<div class="content">
			<header class="article-header">
			<h1 class="article-title">
				<a  title="">${poster.getPosterTitle() }</a>
			</h1>
			<div class="article-meta">
				<span class="item article-meta-time"> <time class="time"
						data-toggle="tooltip" data-placement="bottom" title=""
						data-original-title="发表时间">
					<i class="glyphicon glyphicon-time"></i> ${poster.getPosterTime() }</time>
				</span> <span class="item article-meta-source" data-toggle="tooltip"
					data-placement="bottom" title="" data-original-title="来源"><i
					class="glyphicon glyphicon-globe"></i> ${pname }</span> <span
					class="item article-meta-views" data-toggle="tooltip"
					data-placement="bottom" title="" data-original-title="浏览量"><i
					class="glyphicon glyphicon-eye-open"></i> ${poster.getCounter() }</span> <span
					class="item article-meta-comment" data-toggle="tooltip"
					data-placement="bottom" title="" data-original-title="评论量"><i
					class="glyphicon glyphicon-comment"></i> ${replyList.getReplyList().size() }</span>
					<a href="EditPosterSYH?id=${poster.getPosterID() }" title="修改帖子">修改帖子</a>
			</div>
			</header>
			<article class="article-content">
			<p>${poster.getPosterContent() }</p>

			<div class="bdsharebuttonbox">
				<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
					class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#"
					class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#"
					class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#"
					class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#"
					class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a><a href="#"
					class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
			</div>

			<script>
				window._bd_share_config = {
					"common" : {
						"bdSnsKey" : {},
						"bdText" : "",
						"bdMini" : "2",
						"bdMiniList" : false,
						"bdPic" : "",
						"bdStyle" : "1",
						"bdSize" : "32"
					},
					"share" : {}
				};
				with (document)
					0[(getElementsByTagName('head')[0] || body)
							.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=0.js?cdnversion='
							+ ~(-new Date() / 36e5)];
			</script>
			</article>
			<div class="title" id="comment">
				<h3></h3>
			</div>
			<div id="respond">
				<c:if test="${(islogin==true)&&(identity eq 'user')}">
				<form id="comment-form" name="comment-form" action="AddReply" method="POST">
					<div class="comment">
						<div class="comment-box">
						<input type="hidden" name="posterid" value=${poster.getPosterID() }>
							<textarea placeholder="请留下您的评论或留言" name="replycontent"
								id="comment-textarea" cols="100%" rows="3" tabindex="3"></textarea>
							<div class="comment-ctrl">
								<div class="comment-prompt" style="display: none;">
									<i class="fa fa-spin fa-circle-o-notch"></i> <span
										class="comment-prompt-text">评论正在提交中...请稍后</span>
								</div>
								<div class="comment-success" style="display: none;">
									<i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span>
								</div>
								<button type="submit" name="comment-submit" id="comment-submit"
									tabindex="4">评论</button>
							</div>
						</div>
					</div>
				</form>
				</c:if>
				<c:if test="${(islogin==false)||(identity ne 'user')}">
				<form id="comment-form" name="comment-form" action="login.jsp?please=1" method="POST">
					<div class="comment">
						<div class="comment-box">
						<input type="hidden" name="posterid" value=${poster.getPosterID() }>
							<textarea placeholder="请留下您的评论或留言" name="replycontent"
								id="comment-textarea" cols="100%" rows="3" tabindex="3"></textarea>
							<div class="comment-ctrl">
								<div class="comment-prompt" style="display: none;">
									<i class="fa fa-spin fa-circle-o-notch"></i> <span
										class="comment-prompt-text">评论正在提交中...请稍后</span>
								</div>
								<div class="comment-success" style="display: none;">
									<i class="fa fa-check"></i> <span class="comment-prompt-text">评论提交成功...</span>
								</div>
								<button type="submit" name="comment-submit" id="comment-submit"
									tabindex="4">评论</button>
							</div>
						</div>
					</div>
				</form>
				</c:if>
<stag:ShowReply></stag:ShowReply>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.ias.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
