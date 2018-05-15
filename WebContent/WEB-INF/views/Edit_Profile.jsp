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
	        <li class="breadcrumb-item active">Edit profile</li>
	      </ol>
	       <div class="container">
		    <div class="card card-register mx-auto mt-5">
		      <div class="card-header">Edit profile</div>
		      <div class="card-body">
		        <form:form name="reg" modelAttribute="userdata" action="editprofile" method="post">
		         <div class="form-group">
		            <label>Username</label>
		            <form:input id="userName" path="userName" class="form-control" ></form:input>
		          	<br/><form:errors path="userName" cssClass="alert alert-danger" />
		          </div>
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label >First name</label>
		                <form:input id="fName" path="fName" class="form-control" ></form:input>
		              	<br/><form:errors path="fName" cssClass="alert alert-danger" />
		              </div>
		              <div class="col-md-6">
		                <label >Last name</label>
		                <form:input  path="lName" id="lName" class="form-control"  type="text" aria-describedby="nameHelp" placeholder="Enter last name"></form:input>
		             	<br/><form:errors path="lName" cssClass="alert alert-danger" />
		              </div>
		            </div>
		          </div>
		          <div class="form-group">
		            <label >Email address</label>
		            <form:input id="email" path="email" class="form-control" ></form:input>
		          	<br/><form:errors path="email" cssClass="alert alert-danger" />
		          </div>
		          <!-- <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label >Password</label>
		               <br/> <input name="password" id="password" class="form-control"  type="password" placeholder="Password">
		              </div>
		            </div>
		          </div>
 -->		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label >Age</label>
		                <form:input  path="age" id="age" class="form-control" ></form:input>
		             	<br/><form:errors path="age" cssClass="alert alert-danger" />
		              </div>
		              <div class="col-md-6">
		                <label >DOB</label>
		                <form:input type="date" id="dob" path="dob" class="form-control"></form:input>
		             	<br/><form:errors path="dob" cssClass="alert alert-danger" />
		              </div>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label >Phone</label>
		                <form:input id="phone"  path="phone" class="form-control" ></form:input>
		             	<br/><form:errors path="phone" cssClass="alert alert-danger" />
		              </div>
		              <div class="col-md-6">
		                <label >Gender</label>
		                <form:input id="gender" path="gender" class="form-control" ></form:input>
		              	<br/><form:errors path="gender" cssClass="alert alert-danger" />
		              </div>
		            </div>
		          </div>
		          <div class="form-group">
		            <label >Address</label>
		            <form:input id="userAddress" path="userAddress" class="form-control" ></form:input>
		        	 <br/><form:errors path="userAddress" cssClass="alert alert-danger" />
		         	 </div>
		          <div class="form-group">
		            <label >Aadhaar</label>
		            <form:input id="aadhaarNo" path="aadhaarNo" class="form-control" ></form:input>
		          	<br/><form:errors path="aadhaarNo" cssClass="alert alert-danger" />
		          </div>
		          <form:button type="submit" class="btn btn-success">Register!</form:button>
		        </form:form>
		        
		      </div>
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
	   $("form[name='reg']").validate({
	     // Specify validation rules
	     rules: {
	       // The key name on the left side is the name attribute
	       // of an input field. Validation rules are defined
	       // on the right side
	       userName: "required",
	       dob: "required",
	       fName: "required",
	       lName: "required",
	       userAddress: "required",
	       gender: "required",
	       password: {
	           required: true,
	           minlength: 5
	         },
	         age: {
	        	 range: [13, 60],
	           required: true,
	           number: true
	         },
	         phone: {
	           required: true,
	           number: true
	         },
	         aadhaarNo: {
	           required: true,
	           number: true,
	           minlength: 12
	         },
	          email: {
		        required: true,
		        // Specify that email should be validated
		        // by the built-in "email" rule
		        email: true
		      },
	       
	     },
	     // Specify validation error messages
	     messages: {
	    	 aadhaarNo: "Please enter 12 digit number",
	    	 age: "Please enter age in range 13 to 60",
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