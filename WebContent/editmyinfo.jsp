<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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
<jsp:include page="banner.jsp"></jsp:include>
<body>
<div class="row" style="background-image:url('images/background.jpg')">
	<div class="col-md-3 col-sm-3">
	</div>
	<div class="col-md-6 col-sm-6 main">
        <div class="panel panel-default">
            <div class="panel-heading">
            <img href="homepage.jsp" src="images/icon_SouthDynastyBBS.png" alt="欢迎来到南朝论坛~"/>
                <p>You can edit your Username and Password!</p>
            </div>
            <div class="panel-body">
            	<form method="POST" action="EditMyInfo" >
            	<br><br>
            	    <div class="form-group">
                        <label>Your New Username</label>
                        <input type="text" class="form-control" value="${username}" name="username">
	                </div><br>
	            	<div class="form-group">
                        <label>Your New Password</label>
						<input type="text" class="form-control" name="userpassword"
							onblur="if(this.value == '')this.value='orign';" onclick="if(this.value == 'orign')this.value='';" value="orign">
	                </div>
	                <br><br>
	              	<div class="col-md-6 col-sm-6">
	             		<div></div></div><button type="submit" class="btn btn-primary btn-lg">Submit</button>	              		
	              	</div>
	              	<br><br>
            	</form>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-3">
    </div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>