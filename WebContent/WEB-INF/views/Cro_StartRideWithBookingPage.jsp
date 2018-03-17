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
	        <li class="breadcrumb-item active">Start Ride </li>
	      </ol>
	      <div class="alert  progress-bar bg-primary active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >Start Ride Now!!</strong>
			</div>
			<br/>
	      <form:form modelAttribute="startride" action="doaddridewithbooking"
			method="post">
			<table align="center">
				<tr>
					<td><form:label class="form-text text-muted" path="departureDate" type="date">Depature Date</form:label>
					</td>
					<td><label class="form-text text-muted" >${booking.departureDate}</label>
					<form:input path="departureDate" type="hidden"
							name="departureDate" value="${booking.departureDate}"/>
					</td>
					<td><form:errors path="departureDate" cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td><form:label class="form-text text-muted" path="departureTime">Departure Time</form:label>
					</td>
					<td><form:input type="hidden" path="departureTime" name="departureTime" value="${booking.departureTime}"/>
					<label class="form-text text-muted">${booking.departureTime}</label></td>
					<td><form:errors path="departureTime" cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" path="estimatedEndTime">Estimated End Time<label></td>
					<td><form:input path="estimatedEndTime" value="${booking.estimatedEndTime}" type="hidden"/>
					<label class="form-text text-muted" >${booking.estimatedEndTime}</label></td>
					<td><form:errors path="estimatedEndTime" cssClass="alert alert-danger" />
					</td>
				</tr>

				<tr>
					<td><form:label class="form-text text-muted" path="startStoreName">Start Store Name</form:label>
					</td>
					<td><form:input path="startStoreName" value="${booking.startStoreName}" type="hidden"/>
					<label class="form-text text-muted">${booking.startStoreName}</label></td>
					<td><form:errors path="startStoreName" cssClass="alert alert-danger" /></td>
				</tr>

				<tr>
					<td><form:label class="form-text text-muted" path="cycleId">cycleId</form:label></td>
					<td><form:select path="cycleId" name="cycleId">

							<form:options items="${cyclelist}" />
						</form:select></td>
					<td><form:errors path="cycleId" cssClass="alert alert-danger" /></td>
				</tr>
					<tr>
					<td><form:label class="form-text text-muted" path="userName">username</form:label></td>
					<td>
						<form:input path="userName"
							name="userName" value="${booking.userName}" />
					</td>
					<td><form:errors path="userName" cssClass="alert alert-danger" /></td>
				</tr>
					
				<tr>
					<td><input type="hidden" name="bookingid" value="${booking.bookingId}"/></td>
					<td><form:button type="submit" class="btn btn-primary">Submit</form:button></td>
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