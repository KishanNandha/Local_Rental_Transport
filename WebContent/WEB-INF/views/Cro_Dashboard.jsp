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
	 <link href="${pageContext.request.contextPath}/resources/css/my_admin.css" rel="stylesheet">
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
	        <li class="breadcrumb-item active">Blank Page</li>
	      </ol>
	      	        
    <div class="container-2">
      <div class="row ">
         <div class="col-lg-12">
         <div class="tile tile-img tile-time morning" style="height: 200px">
           <p class="time-widget">
            <span class="time-widget-heading">It Is Currently</span>
             <br>
              <strong><span id="datetime"><span> <%
         Date d2Now = new Date( );
         SimpleDateFormat f2t = 
         new SimpleDateFormat ("E  yyyy-MM-dd ");
         out.print(  f2t.format(d2Now) ); %>
         <br/><i class="fa fa-clock-o" color:red"></i>
          <span class="clock font-weight-bold font-italic"></span></span></span></strong>
           </p>
         </div>
        </div>
         <div class="col-lg-9"></div>  
            
        </div>
                                   
        <div class="row" >
        		<div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/startridewithoutbooking">
                                <div class="circle-tile-heading blue">
                                    <i class="fa fa-tasks fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content blue">
                                <div class="circle-tile-description text-faded">
                                    Start Ride Without Booking
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineB"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/startridewithoutbooking" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/startridewithbooking">
                                <div class="circle-tile-heading blue">
                                    <i class="fa fa-tasks fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content blue">
                                <div class="circle-tile-description text-faded">
                                     Start Ride With Booking
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineB"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/startridewithbooking" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/endridepanel">
                                <div class="circle-tile-heading blue">
                                    <i class="fa fa-tasks fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content blue">
                                <div class="circle-tile-description text-faded">
                                    End Ride
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineB"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/endridepanel" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/viewalluserdetailspanel">
                                <div class="circle-tile-heading dark-blue">
                                    <i class="fa fa-users fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content dark-blue">
                                <div class="circle-tile-description text-faded">
                                   User-Info
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineA"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/viewalluserdetailspanel" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/reg">
                                <div class="circle-tile-heading orange">
                                    <i class="fa fa-bell fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content orange">
                                <div class="circle-tile-description text-faded">
                                    ADD user/cro
                                </div>
                                <div class="circle-tile-number text-faded">
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/reg" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/viewallrideofstore">
                                <div class="circle-tile-heading blue">
                                    <i class="fa fa-tasks fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content blue">
                                <div class="circle-tile-description text-faded">
                                    Store Rides
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineB"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/viewallridesofstorepanel" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-sm-6">
                        <div class="circle-tile">
                            <a href="${pageContext.request.contextPath}/cro/viewallridesofuserpanel">
                                <div class="circle-tile-heading red">
                                    <i class="fa fa-shopping-cart fa-fw fa-3x"></i>
                                </div>
                            </a>
                            <div class="circle-tile-content red">
                                <div class="circle-tile-description text-faded">
                                    User rides
                                </div>
                                <div class="circle-tile-number text-faded">
                                    <span id="sparklineC"></span>
                                </div>
                                <a href="${pageContext.request.contextPath}/cro/viewallridesofuserpanel" class="circle-tile-footer">More Info <i class="fa fa-chevron-circle-right"></i></a>
                            </div>
                        </div>
                    </div>
                    
                    </div>
                </div>
                                                     
        
    </div><!-- page-wrapper END-->
   </div><!-- container-1 END-->
 
    
    <script src="js/jquery-3.1.1.js"></script>    
    <script src="js/bootstrap.js"></script>
    


<script type="text/javascript">
    $(document).ready(function(){
        $(".sidebar-toggle").click(function(){
            $(this).hide();
            
           $("#user-profil").show();
            
           $("#hide-btn").show();
            
           $(".container-2").css("width", "85%");
            
             
        });
        
        $("#hide-btn").click(function(){
            $(this).hide();
            
           $("#user-profil").hide();
            
           $(".sidebar-toggle").show();
            
           $(".container-2").css("width", "100%");
            
             
        });
    });
</script>

   
 
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