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
   <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/round-about.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<%@include file="NavBar_PRE.jsp" %>
    <div class="content-wrapper">
    	<div class="container-fluid">
	      <!-- Breadcrumbs-->
	      <ol class="breadcrumb">
	        <li class="breadcrumb-item">
	          <a href="${pageContext.request.contextPath}/login">Dashboard</a>
	        </li>
	        <li class="breadcrumb-item active">About Us</li>
	      </ol>
	       <!-- Introduction Row -->
      <h1 class="my-4">About Us<br/>
        <small>It's Nice to Meet You!</small>
      </h1>
      <h1>What We Do?</h1>
		<p>Nowadays, there are many online reservations which give much benefit to user. 
		A rental service is a service in which customers arrive to request the hire of a rental unit. 
		It is more convenient than owning and maintaining the unit.
		 There are many rental system that include customers manual inquiries.
		  They will fill-out(manually) forms to rent a vehicle. 
		  The form will be submitted to the office. After the verification process is completed, vehicle information will be delivered. 
		  The research aims to build an online local rental transport. Therefore with this new method, the process will be more efficient and the safety of hiring vehicle is secure.
		   Its also the best way to increase the quality of management and can reduce the time constraints. local rental transport provides complete functionality of listing and booking . 
		In this system, complains and other such facilities also provided.
		</p>
		<p>
		In todays fast moving world, people really feel about the importance
		of time and hence they do not want to waste time. So everyone is getting drawn towards excellent
		and professional service that ensures quality and no wastage of unnecessary time. In our
		opinion, the service provided by us to the people will benefit them largely as there are around
		1000 daily commuters in Ahmedabad, who still prefer cycles over long waiting for buses as they believe that travelling by cycle would make them reach their destination early as
		compared to any other conveyance opted. 
		</p>
		
		<h1>Future Enhancements</h1>
		
		<p>
		If an appropriate module for secure payment is identified or externally developed,
     then it shall be incorporated in the next version.Also, the feature for tracking the passenger's real-time location while in a journey,
     needs cash flow and simultaneous deployment activity, hence serious
     professionals should be consulted and if found feasible then, shall be
     incorporated in the next version.   
      
		
		</p>
		
		<h1>Conclusion</h1>
		
		<p>
		Local Rental Transport is a Web application and it is restricted to only limited type of users.

 Local Rental Transport is a service, in which customers arrive to rent Transport units like       	cycles and bikes. It provides “Drop Anywhere & Pick from Anywhere” service. 

 In this application different types of users and  have been given access rights and they       cro are restricted up to their functionalities, so that the data is maintained securely and redundant data is  prevented. 

Here The Details  of Users,CRO, Cycle are maintained. But user are unable to view their details .
      <!-- Team Members Row -->
      <div class="row">
        <div class="col-lg-12">
          <h2 class="my-4">Our Team</h2>
        </div>
        <div class="col-lg-6 col-sm-6 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="${pageContext.request.contextPath}/resources/images/kn.JPG" alt="">
          <h3>Kishan Nandha
            <small>Developer</small>
          </h3>
          <p>L.J. Institute Of Engineering and Technology</p>
        </div>
        <div class="col-lg-6 col-sm-6 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="${pageContext.request.contextPath}/resources/images/kt.JPG" alt="">
          <h3>Kishan Thakkar
            <small>Developer</small>
          </h3>
          <p>L.J. Institute Of Engineering and Technology</p>
        </div>
        <div class="col-lg-6 col-sm-6 text-center mb-4">
          <img class="rounded-circle img-fluid d-block mx-auto" src="${pageContext.request.contextPath}/resources/images/jainish.JPG" alt="">
          <h3>Jainish Patel
            <small>Developer</small>
          </h3>
          <p>L.J. Institute Of Engineering and Technology</p>
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