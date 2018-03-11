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
	<%@include file="NavBar_PRE.jsp"%>
    <div class="content-wrapper">
    	<div class="container-fluid">
	      <!-- Breadcrumbs-->
	      <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="${pageContext.request.contextPath}/login">Home Page</a>
	        </li>
	      </ol>
	      
		      <h1 class="my-4">Welcome to Local Rental Transport</h1>

     
   <div class="row">
        <div class="col-lg-6">
          <h2>Local Rental Transport:</h2>
          <p>At Local Rental Transport we look for giving the first push to people who would like to experience the joy of cycling.
We offer cycles on rentals at nominal rates. In return, we hope for a better traffic scene, healthier friends and clean air to breathe.</p><p>
Our cycles are awesome, rents are nominal, and terms and conditions are minimal.</p>
        <h2>Drop anywhere, Pick from anywhere</h2>
          <p>Bikes are a great way to move around; but sometimes distances get too long! In such case, members can opt for an ‘additional’ facility wherein they can drop the bike at any LRT Terminal, situated at the nearest public transport transit point/station, and similarly pick up another bike from any other LRT Terminal</p>
        </div>
        <div class="col-lg-6">
          <img class="img-fluid rounded" src="${pageContext.request.contextPath}/resources/res/1.gif" alt="">
        </div>
      </div>

      <hr>
      <h1 class="text-center">Whom is it for??</h1>
      <br/>
	<div class="row">
     <div class="content-image pull-left col-xs-6 text-left"> <img src="${pageContext.request.contextPath}/resources/images/bike-owners.png"> </div>
      <div class="pull-right col-xs-6 ">
       
        <h1>Bikers </h1>
        <p><strong>Why buy a bike when you can have LRT?</strong> Unlike your personal bike, with LRT you don’t have to worry about its repairs and maintenance. All bikes are checked and serviced at regular intervals. Nevertheless, should the bike still malfunction; simply replace the bike with another one.</p>
      
      </div>
      <br/>
      <br/>
      <br/>
      <div class="content-image"> <img src="${pageContext.request.contextPath}/resources/images/public-transport.png"> </div>
      <div>
       
        <h1>Public Transport Users</h1>
        <p>LRT helps make public transport more accessible, convenient, economical and time efficient. Connect your first 
          
          and last mile using our ‘Drop Anywhere, Pick from Anywhere’ facility and save time &amp; money in a healthier and 
          
          environment friendly manner.</p>
 
      </div>
      <div class="content-image"> <img src="${pageContext.request.contextPath}/resources/images/campus-area.png"> </div>
      <div>
       
        <h1>Students</h1>
        <p>Make the most of your lush green campus with LRT. LRT helps students by making intra-campus commute 

fast and easy. So what are you waiting for? Explore your campus like never before! </p>
 
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
  </div>
</body>
</html>