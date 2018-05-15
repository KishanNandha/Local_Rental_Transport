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
	        <li class="breadcrumb-item active">End ride</li>
	      </ol>
	      <div class="alert  progress-bar bg-danger active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >End Ride!</strong>
			</div>
			<br/>
	      <form:form modelAttribute="endride" action="doendride"
			method="post">
			<table align="center">
				<tr>
					<td><label class="form-text text-muted" >Start Ride ID:</label></td>
					<td>${statride.startRideId}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >User Name:</label></td>
					<td>${statride.userName}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >Start Store Name:</label></td>
					<td>${statride.startStoreName}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >Departure Date:</label></td>
					<td>${statride.departureDate}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >Departure Time:</label></td>
					<td>${statride.departureTime}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >Estimated End Time:</label></td>
					<td>${statride.estimatedEndTime}</td>
					<td></td>
				</tr>
				<tr>
					<td><label class="form-text text-muted" >Cycle Id:</label></td>
					<td>${statride.cycleId}</td>
					<td></td>
				</tr>
				<tr>
					<td>
					</td>
					<td><form:input class="form-control form-control-md" path="startRideId"
							name="startRideId" value="${statride.startRideId}" type="hidden"/></td>
					<td><form:errors path="startRideId" cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td><form:label class="form-text text-muted"  path="endTime">End Time</form:label>
					</td>
					<td><form:select class="form-control form-control-md" path="endTime" name="endTime">
								<form:option value=""></form:option>
											<form:option value="6.00 AM"></form:option>
											<form:option value="7.00 AM"></form:option>
											<form:option value="8.00 AM"></form:option>
											<form:option value="9.00 AM"></form:option>
											<form:option value="10.00 AM"></form:option>
											<form:option value="11.00 AM"></form:option>
											<form:option value="12.00 PM"></form:option>
											<form:option value="1.00 PM"></form:option>
											<form:option value="2.00 PM"></form:option>
											<form:option value="3.00 PM"></form:option>
											<form:option value="4.00 PM"></form:option>
											<form:option value="5.00 PM"></form:option>
											<form:option value="6.00 PM"></form:option>
											<form:option value="7.00 PM"></form:option>
											<form:option value="8.00 PM"></form:option>
											<form:option value="9.00 PM"></form:option>
											<form:option value="10.00 PM"></form:option>
											<form:option value="11.00 PM"></form:option>
						</form:select></td>
					<td><form:errors path="endTime" cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td><form:label class="form-text text-muted"  path="endStoreName">End Store Name</form:label>
					</td>
					<td><form:select class="form-control form-control-md" path="endStoreName" name="endStoreName"
							type="text">

							<form:options items="${storeslist}" />
						</form:select></td>
					<td><form:errors path="endStoreName" cssClass="alert alert-danger" /></td>
				</tr>
				
				</tr>
						<%-- <tr>
					<td><form:label class="form-text text-muted"  path="totalAmount">Total Amount</form:label></td>
					<td>
						<form:input class="form-control form-control-md" path="totalAmount"
							name="totalAmount" />
					</td>
					<td><form:errors path="totalAmount" cssClass="alert alert-danger" /></td>
				</tr> --%>
					<tr>
					<td><form:label class="form-text text-muted"  path="anyDamage">Any Damage?</form:label></td>
					<td>
						<form:select class="form-control form-control-md" path="anyDamage" name="endTime" type="text">
							<form:option value="NO"></form:option>
							<form:option value="YES"></form:option>
						</form:select>
					</td>
					<td><form:errors path="anyDamage" cssClass="alert alert-danger" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button type="submit" class="btn btn-danger">End Ride</form:button></td>
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