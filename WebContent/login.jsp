<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
body 
{
	background-image:url('images/background.jpg');
	background-color:#cccccc;
}
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
<body>

<jsp:include page="banner.jsp"></jsp:include>

<div class="row">
	<div class="col-md-2 col-sm-2">
	</div>
	<div class="col-md-6 col-sm-6 main">
        <div class="panel panel-default">
            <div class="panel-heading">
            <img href="homepage.jsp" src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~"/>
                <p>Please Input your ID and Password!</p>
            </div>
            <div class="panel-body">
            	<form method="POST" action="UserLogin" >
	            	<div class="form-group">
                        <label>Input your ID</label>
                        <input type="text" class="form-control" placeholder="ID">
	                </div>
	            	<div class="form-group">
                        <label>Input your Password</label>
                        <input type="password" class="form-control" placeholder="password">
	                </div>
	              	<div class="col-md-6 col-sm-6">
	             		<button type="submit" class="btn btn-primary btn-lg">Submit</button>	              		
	              	</div>
	              	<div class="col-md-6 col-sm-6">
	              		<button type="reset" class="btn btn-primary btn-lg">Reset</button>
	              	</div> 
            	</form>
            </div>
        </div>
    </div>
    <div class="col-md-2 col-sm-2">
    </div>
</div>
</body>
</html>