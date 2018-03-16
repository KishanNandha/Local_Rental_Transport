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
	        <li class="breadcrumb-item active">View End Rides</li>
	      </ol>
	     <div class="alert  progress-bar bg-success active">
	      <!-- <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
			  <strong class="text-center" >View End Rides!!</strong>
			</div>
			<br/>
	       <div class="card  text-white bg-info o-hidden h-100 mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> &nbsp Booking Data Table </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>End Ride Id</th>
                  <th>startRideId</th>
                  <th>End Time</th>
                  <th>End Store Name</th>
                  <th>Total Time</th>
                  <th>Total Amount</th>
                  <th>anyDamage</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${endridelist}" var="bookings">
                <tr>
                  <td>${bookings.endRideId}</td>
                  <td>${bookings.startRideId}</td>
                  <td>${bookings.endTime}</td>
                  <td>${bookings.endStoreName}</td>
                  <td>${bookings.totalTime}</td>
                  <td>${bookings.totalAmount}</td>
                  <th>${bookings.anyDamage}</th>
                </tr>
                </c:forEach>
                  </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-white ">Updated yesterday at 11:59 PM</div>
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