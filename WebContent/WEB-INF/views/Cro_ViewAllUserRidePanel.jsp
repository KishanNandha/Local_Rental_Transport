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
<style type="text/css">
form {
  
}
form .error {
  color: #ff0000;
}
</style>
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
	        <li class="breadcrumb-item active">View Rides of User</li>
	      </ol>
	      <div class="alert  progress-bar bg-info active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >View Rides of User!!</strong>
			</div>
			<br/>
	      
	       <div class="panel panel-info">
		      <div class="panel-heading">Enter User name:</div>
		      <div class="panel-body">
		      	<form name="viewallrideofuser" action="viewallrideofuser">
		      		<input type="text" class="form-control form-control-md" id="username" name="username"/><br/>
		      		<input type="submit" class="btn btn-info" value="Search"/>
		      	</form>
		      </div>
		    </div>
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
  <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
	 <script type="text/javascript">
   $(function() {
	   // Initialize form validation on the registration form.
	   // It has the name attribute "registration"
	   $("form[name='viewallrideofuser']").validate({
	     // Specify validation rules
	     rules: {
	       // The key name on the left side is the name attribute
	       // of an input field. Validation rules are defined
	       // on the right side
	       username: "required",
	       
	     },
	     // Specify validation error messages
	     messages: {
	     },
	     // Make sure the form is submitted to the destination defined
	     // in the "action" attribute of the form when valid
	     submitHandler: function(form) {
	       form.submit();
	     }
	   });
	 });
   </script>
  </div>
</body>
</html>