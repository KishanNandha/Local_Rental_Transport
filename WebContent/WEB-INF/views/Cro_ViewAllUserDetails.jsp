<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>LRT</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="NavBar_CRO.jsp"%>
    <div class="content-wrapper">
    	<div class="container-fluid">
	      <!-- Breadcrumbs-->
	      <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="${pageContext.request.contextPath}/cro/home">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">User Details</li>
	      </ol>
	      <div class="alert  progress-bar bg-success active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >User Details!!</strong>
			</div>
			<br/>
	      <br/><br/>
	      <table align="center">
	
	      		<tr><td><label class="form-text text-muted">userID</label></td><td>${userdetails.userID}</td></tr>
	      		<tr><td><label class="form-text text-muted">userName</label></td><td>${userdetails.userName}</td></tr>
	      		<tr><td><label class="form-text text-muted">fName</label></td><td>${userdetails.fName}</td></tr>
	      		<tr> <td><label class="form-text text-muted">lName</label></td><td>${userdetails.lName}</td></tr>
	      		<tr><td><label class="form-text text-muted">email</label></td><td>${userdetails.email}</td></tr>
	      		<tr><td><label class="form-text text-muted">phone</label></td><td>${userdetails.phone}</td></tr>
	      		<tr><td> <label class="form-text text-muted">dob</label></td><td>${userdetails.dob}</td></tr>
	      		<tr> <td><label class="form-text text-muted">age</label></td><td>${userdetails.age}</td></tr>
	      		<tr><td><label class="form-text text-muted">userAddress</td></label><td>${userdetails.userAddress}</td></tr>
	      		<tr><td><label class="form-text text-muted">gender</label></td><td>${userdetails.gender}</td></tr>
	      		<tr><td><label class="form-text text-muted">aadhaarNo</label></td><td>${userdetails.aadhaarNo}</td></tr>
	      
	      </table>
	      
	      
	      
	     
	      
	      
	     
	     
	      
	      
	      
        </div>
    </div>
    <%@include file="footer.jsp"%>
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js"></script>
  </div>
</body>
</html>