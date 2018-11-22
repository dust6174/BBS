<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Poster</title>
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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	编辑帖子
                        </div>
                        <form method="POST" action="ChangePosterInfo">
                            <div class="panel-body">
                            	<div class="row">
                            		<div class="col-md-4 col-sm-4">
                            			帖子序号:
                            		</div>
                               	 	<div class="col-md-8 col-sm-8">
                               	 	<input type="text" class="form-control"  name="posterid" value="${poster.posterID}" readOnly>
                               		</div>
                               	</div>
                            	<div class="row">
                            		<div class="col-md-4 col-sm-4">
                            			帖子标题:
                            		</div>
                               	 	<div class="col-md-8 col-sm-8">
                               	 	<input type="text" class="form-control"  name="postertitle" value="${poster.posterTitle}">
                               		</div>
                               	</div>
                               	<div class="row">
                            		<div class="col-md-4 col-sm-4">
                               			所在版块:
                               		</div>
                               		<div class="col-md-8 col-sm-8"><%-- 
                               			<input type="text" class="form-control"  name="postertitle" value="${poster.BoardID}" disabled> --%>
                               			
                                            <select name="boardid" class="form-control">
                                                <c:forEach var="board" items="${boards}">
                                                    <option  value="<c:out value="${board.boardID}"/>"  
                                                    
                                                		<c:if test="${board.boardID eq poster.boardID}">
		                                                    selected
                                                		</c:if>
                                                    >
                                                    	<c:out value="${board.boardID}"/>: <c:out value="${board.boardTitle}"/>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                    </div>
                                 </div>
				                          帖子内容:
				              <textarea type="text" class="form-control"  name="postercontent" class="form-control" rows="10"> ${poster.posterContent}</textarea>
				            		
				            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-6 col-sm-6">
                                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>                        
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <button type="reset" class="btn btn-primary btn-lg">Reset</button>
                                    </div>
                                </div> 
                            </div>
                        </form>
                    </div>
                </div>

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>