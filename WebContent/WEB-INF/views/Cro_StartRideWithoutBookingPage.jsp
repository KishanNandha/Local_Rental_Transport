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
	        <li class="breadcrumb-item active">Start Ride</li>
	      </ol>
	      <div class="alert  progress-bar bg-info active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >Start Ride Now!!</strong>
			</div>
			<br/>
	      <form:form modelAttribute="startride"
							action="doaddridewithoutbooking" method="post">
							<table align="center">
								<tr>
									<td><form:label class="form-text text-muted" path="departureDate" type="date">Depature Date</form:label>
									</td>
									<td><form:input class="form-control form-control-md"  path="departureDate" type="date"
											name="departureDate" /></td>
									<td><form:errors path="departureDate" cssClass="alert alert-danger" />
									</td>
								</tr>
								<tr>
									<td><form:label class="form-text text-muted" path="departureTime">Departure Time</form:label>
									</td>
									<td><form:select class="form-control form-control-md"  path="departureTime" name="departureTime">
											<form:option value="6.00AM"></form:option>
											<form:option value="7.00AM"></form:option>
											<form:option value="8.00AM"></form:option>
											<form:option value="9.00AM"></form:option>
											<form:option value="10.00AM"></form:option>
											<form:option value="11.00AM"></form:option>
											<form:option value="12.00PM"></form:option>
											<form:option value="1.00PM"></form:option>
											<form:option value="2.00PM"></form:option>
											<form:option value="3.00PM"></form:option>
											<form:option value="4.00PM"></form:option>
											<form:option value="5.00PM"></form:option>
											<form:option value="6.00PM"></form:option>
											<form:option value="7.00PM"></form:option>
											<form:option value="8.00PM"></form:option>
											<form:option value="9.00PM"></form:option>
											<form:option value="10.00PM"></form:option>
											<form:option value="11.00PM"></form:option>
										</form:select></td>
									<td><form:errors path="departureTime" cssClass="alert alert-danger" />
									</td>
								</tr>
								<tr>
									<td><form:label class="form-text text-muted" path="estimatedEndTime">Estimated End
											Time</form:label></td>
									<td><form:select class="form-control form-control-md"  path="estimatedEndTime"
											name="estimatedEndTime">
											<form:option value="6.00AM"></form:option>
											<form:option value="7.00AM"></form:option>
											<form:option value="8.00AM"></form:option>
											<form:option value="9.00AM"></form:option>
											<form:option value="10.00AM"></form:option>
											<form:option value="11.00AM"></form:option>
											<form:option value="12.00PM"></form:option>
											<form:option value="1.00PM"></form:option>
											<form:option value="2.00PM"></form:option>
											<form:option value="3.00PM"></form:option>
											<form:option value="4.00PM"></form:option>
											<form:option value="5.00PM"></form:option>
											<form:option value="6.00PM"></form:option>
											<form:option value="7.00PM"></form:option>
											<form:option value="8.00PM"></form:option>
											<form:option value="9.00PM"></form:option>
											<form:option value="10.00PM"></form:option>
											<form:option value="11.00PM"></form:option>
										</form:select></td>
									<td><form:errors path="estimatedEndTime" cssClass="alert alert-danger" />
									</td>
								</tr>

								<tr>
									<td><form:label class="form-text text-muted" path="startStoreName">Start Store Name</form:label>
									</td>
									<td><form:select class="form-control form-control-md"  path="startStoreName"
											name="startStoreName" type="text">

											<form:options items="${storeslist}" />
										</form:select></td>
									<td><form:errors path="startStoreName" cssClass="alert alert-danger" />
									</td>
								</tr>

								<tr>
									<td><form:label class="form-text text-muted" path="cycleId">cycleId</form:label></td>
									<td><form:select class="form-control form-control-md"  path="cycleId" name="cycleId">

											<form:options items="${cyclelist}" />
										</form:select></td>
									<td><form:errors path="cycleId" cssClass="alert alert-danger" /></td>
								</tr>

								<tr>
								<tr>
									<td><form:label class="form-text text-muted" path="userName">Username</form:label></td>
									<td><form:input class="form-control form-control-md"  path="userName" name="userName" /></td>
									<td><form:errors path="userName" cssClass="alert alert-danger" /></td>
								</tr>
								<tr>
									<td></td>
									<td><form:button type="submit" class="btn btn-info">Start!</form:button></td>
								</tr>
								<tr></tr>

							</table>
						</form:form>
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