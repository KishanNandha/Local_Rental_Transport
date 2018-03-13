<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
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
	<%@include file="NavBar_USER.jsp"%>
    <div class="content-wrapper">
    	<div class="container-fluid">
	      <!-- Breadcrumbs-->
	      <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="${pageContext.request.contextPath}/user/home">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">View Bookings</li>
	      </ol>
	      <br/>
	      <c:if test="${bookingdeletedflag == 1}">
				<div class="alert alert-success alert-dismissible">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				  <strong>Booking Deleted!</strong><br/>
				  <strong>${bookingdeletedmsg}</strong>
				</div>				
		  </c:if>
	      <br/>
	       <div class="card text-white bg-secondary  mb-3">
        <div class="card-header ">
          <i class="fa fa-table"></i> &nbsp Booking Data Table </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Booking ID</th>
                  <th>Departure Date</th>
                  <th>Departure Time</th>
                  <th>Estimatedend Time</th>
                  <th>Start Store Name</th>
                  <th>Delete Action</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${bookinglist}" var="bookings">
                <tr>
                  <td>${bookings.bookingId}</td>
                  <td>${bookings.departureDate}</td>
                  <td>${bookings.departureTime}</td>
                  <td>${bookings.estimatedEndTime}</td>
                  <td>${bookings.startStoreName}</td>
                  <td>
                  	<form method="get" action="deletebooking">
                  		<input type="hidden" name="bookingid" value="${bookings.bookingId}"/>
                  		<input type="submit" value="Delete" class="btn btn-danger">
                  	</form>
                  </td>
                </tr>
                </c:forEach>
                  </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
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
  </div>
</body>
</html>