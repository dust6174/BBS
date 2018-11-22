<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet">
     <!-- Google Fonts-->
   <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
	<style>
.main{
    text-align: center; /*让div内部文字居中*/
	opacity: 0.7;
	height:50%;
	position: absolute;
    margin: auto;
    top: 0; left: 0; right: 0; bottom: 0;
}
</style>

<script>

</script>

</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="row" style="background-image:url('images/background.jpg')">
	<div class="col-md-3 col-sm-3">
	</div>
	<div class="col-md-6 col-sm-6 main">
        <div class="panel panel-default">
            <div class="panel-heading">
            <img href="homepage.jsp" src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~"/>
                <p>Please Input your ID and Password!</p>
            </div>
            <div class="panel-body">
            	<form method="POST" action="Login?identity=user" >
	            	<div class="form-group">
                        <label>Input your ID</label>
                        <input type="text" class="form-control" placeholder="ID" name="userid" value="${cookie.userid.value}">
	                </div>
	            	<div class="form-group">
                        <label>Input your Password</label>
                        <input type="password" class="form-control" placeholder="password" name="userpassword" value="${cookie.userpassword.value}">
	                </div>
					<div class="row">
		              	<div class="col-md-6 col-sm-6">
		             		<button type="submit" class="btn btn-primary btn-lg">Submit</button>	              		
		              	</div>
		              	<div class="col-md-6 col-sm-6">
		              		<button type="reset" class="btn btn-primary btn-lg">Reset</button>
		              	</div>
	              	</div> 
            	</form>
                <c:if test="${param.login!=null}">
                    <c:if test="${param.login eq '1'}">
                        <div class="alert alert-danger">
                                <strong>警告!</strong> 禁止重复登录！
                        </div>
                    </c:if>
                    <c:if test="${param.login eq '2'}">
                        <div class="alert alert-danger">
                                <strong>警告!</strong> 不存在此用户！
                        </div>
                    </c:if>
                    <c:if test="${param.login eq '3' }">
                        <div class="alert alert-danger">
                                <strong>警告！</strong>密码错误！
                        </div>
                    </c:if>
                </c:if>
                <c:if test="${param.please eq '1' }">
                        <div class="alert alert-danger">
                                <strong>警告！</strong>请登录，登陆后才能跟帖！
                        </div>
                </c:if>
<%--                 <c:if test="${param.login==null}">
                	<div class="alert alert-danger">
                                <strong>警告!</strong> login为空
                        </div>
                </c:if> --%>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-3">
    </div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>