<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>LRT</title>

    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
    <style type="text/css">
	body{background: url('${pageContext.request.contextPath}/resources/res/3.jpg') no-repeat   center center fixed;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;}
</style>

  </head>

  <body>
    <%@include file="NavBar_USER.jsp" %>
     <br/>
    <!-- Page Content -->
    <div class="container">
    <a class="btn btn-danger" href="${pageContext.request.contextPath}/testinsert">insert</a>
     <a class="btn btn-danger" href="${pageContext.request.contextPath}/testdelete">delete</a>
      <a class="btn btn-danger" href="${pageContext.request.contextPath}/testupdate">update</a>
      
    
     <%@include file="footer.jsp"%>
	
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>