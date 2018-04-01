<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>LRT</title>
<!-- Bootstrap core CSS-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin.css"
	rel="stylesheet">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Varela+Round');

/* General Styles */
body {
	font-size: 16px;
	line-height: 25px;
	padding-top: 50px;
	font-family: 'Varela Round', sans-serif;
	background-color: #e7e7e7;
	padding-bottom: 50px;
}

.color-invoice {
	background-color: #ffffff;
	border: 1px solid #d7d7d7;
	padding-top: 100px;
	padding-bottom: 100px;
}
</style>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="NavBar_CRO.jsp"%>
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/cro/home">Dashboard</a></li>
				<li class="breadcrumb-item active">Conform</li>
			</ol>

			<c:if test="${endridefailed == 0}">
				<!-- <div class="alert alert-success alert-dismissible">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				  <strong>Endride Success!</strong><br/>
				  <strong>Endride Id: &nbsp ${endrideid} </strong>
				  <strong>Total Time: &nbsp ${TotalTime} </strong>
				  <strong>Total Amount: &nbsp ${TotalAmount} </strong>
				</div>	 -->
				<div class="container">
					<div class="row color-invoice">
						<div class="col-md-12">
							<div class="row">
								<div class="col-lg-7 col-md-7 col-sm-7">
									<h1>Local Rental Transport</h1><br/>
									<h1>INVOICE</h1>
									<br /> <strong>Email : </strong> localrentaltransport@gmail.com <br /> <strong>Call
										: </strong> +919428473433
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5">

									<h2>LRT.</h2>
									LJ Institute of Engineering & Technology S.G. Highway,<br>380054<br>
									Ahmedabad

								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-7 col-md-7 col-sm-7">
									<h3>Client Details :</h3>
									<h5>${sessionScope.clientBean.fName } &nbsp; ${sessionScope.clientBean.lName }</h5>
									 ${sessionScope.clientBean.userAddress }<br /> 
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5">
									<h3>Client Contact :</h3>
									 ${sessionScope.clientBean.phone }<br> email: ${sessionScope.clientBean.email }
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<strong>Ride DESCRIPTION & DETAILS :</strong>
								</div>
							</div>
							<hr />
							<form action="makepayment">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="table-responsive">
										<table class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>S. No.</th>
													<th>Perticulars</th>
													<th>Unit</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>StartRide ID</td>
													<td>
													 <%
														 	Random randomGenerator = new Random();
															int randomInt = randomGenerator.nextInt(1000000);
 														%>
													<input type="hidden" id="ORDER_ID" tabindex="1" maxlength="20" size="20"
															name="ORDER_ID" autocomplete="off"
																value="ORDS_<%= randomInt %>">
													${endrideid}</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Start Store</td>
													<td>
													<input type="hidden" id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST${sessionScope.clientBean.userID }"/>
													${StartStore}</td>
													
												</tr>
												<tr>
													<td>3</td>
													<td>Departure Date</td>
													<td>
													<input type="hidden" id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail">
													${DepartureDate}</td>
												</tr>
												<tr>
													<td>4</td>
													<td>Departure Time</td>
													<td>
													<input type="hidden" id="CHANNEL_ID" tabindex="4" maxlength="12"
														size="12" name="CHANNEL_ID" autocomplete="off" value="WEB">
													${DepartureTime}</td>
												</tr>
												<tr>
													<td>5</td>
													<td>End Time</td>
													<td>${EndTime}</td>
												</tr>
												<tr>
													<td>6</td>
													<td>End Store</td>
													<td>${EndStore}</td>
												</tr>
												<tr>
													<td>7</td>
													<td>Total Time</td>
													<td>
													<input type="hidden" title="TXN_AMOUNT" tabindex="10"
														type="text" name="TXN_AMOUNT"
															value="${TotalAmount}">
													${TotalTime}</td>
												</tr>
												
											</tbody>
										</table>
									</div>
									<hr>
									<div>
									
										<h4>Total : ${TotalAmount} INR</h4>
									</div>
									<hr />
								</div>
							</div>
							
							<hr />
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<input class="btn btn-primary btn-lg" value="CheckOut" type="submit" onclick="">
								</div>
							</div>
							</form>
							<hr>
							<div class="row"></div>
						</div>
					</div>
				</div>
				<a href="${pageContext.request.contextPath}/cro/home" class="link">Go
					to Home</a>.			
		  </c:if>
			<c:if test="${endridefailed == 1}">
				<div class="alert alert-danger alert-dismissible">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Endride Failed!</strong><br /> <strong>${endrideerrormsg}
					</strong>
				</div>
				<a href="${pageContext.request.contextPath}/cro/home" class="link">Go
					to Home</a>.
		  </c:if>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js"></script>
	</div>
</body>
</html>