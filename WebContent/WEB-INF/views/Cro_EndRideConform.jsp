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
							#Sr. No: 78660
							<div class="row">
								<div class="col-lg-7 col-md-7 col-sm-7">
									<h1>INVOICE</h1>
									<br /> <strong>Email : </strong> info@HtmlSnipp.com <br /> <strong>Call
										: </strong> +1-6655-44-453
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5">

									<h2>Html Snipp LLC</h2>
									789/89 , Lane Set , New York, <br> Pin- 90-89-78-00, <br>
									United States.

								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-7 col-md-7 col-sm-7">
									<h3>Client Details :</h3>
									<h5>Jhon Williams</h5>
									789/90 , Lane Here, New York, <br /> United States
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5">
									<h3>Client Contact :</h3>
									Mob: +1-99-88-77-55 <br> email: info@domainname.com
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<strong>ITEM DESCRIPTION & DETAILS :</strong>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="table-responsive">
										<table class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>S. No.</th>
													<th>Perticulars</th>
													<th>Quantity.</th>
													<th>Unit Price</th>
													<th>Sub Total</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Website Design</td>
													<td>1</td>
													<td>5000 USD</td>
													<td>5000 USD</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Website Development</td>
													<td>2</td>
													<td>5000 USD</td>
													<td>10000 USD</td>
												</tr>
												<tr>
													<td>3</td>
													<td>Customization</td>
													<td>1</td>
													<td>4000 USD</td>
													<td>4000 USD</td>
												</tr>
												<tr>
													<td>4</td>
													<td>Plugin Setup</td>
													<td>1</td>
													<td>3000 USD</td>
													<td>3000 USD</td>
												</tr>
											</tbody>
										</table>
									</div>
									<hr>
									<div>
										<h4>Total : 22000 USD</h4>
									</div>
									<hr>
									<div>
										<h4>Taxes : 4400 USD ( 20 % on Total Bill )</h4>
									</div>
									<hr>
									<div>
										<h3>Bill Amount : 26400 USD</h3>
									</div>
									<hr />
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<strong> Important: </strong>
									<ol>
										<li>Lorem ipsum dolor sit amet, consectetur adipiscing
											elit.</li>
										<li>Nulla eros eros, laoreet non pretium sit amet,
											efficitur eu magna.</li>
										<li>Curabitur efficitur vitae massa quis molestie. Ut
											quis porttitor justo, sed euismod tortor.</li>
									</ol>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<a href="#" class="btn btn-success btn-sm">Print Invoice</a>
									    <a href="#" class="btn btn-info btn-sm">Download In Pdf</a>
								</div>
							</div>

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