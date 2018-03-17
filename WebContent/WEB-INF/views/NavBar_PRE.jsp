<div id="load"></div>
<!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/login"><i class="fa fa-fw fa-bicycle"></i>  &nbsp Local Rental Transport</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" data-toggle="modal" data-target="#loginModal">
            <i class="fa fa-fw fa-sign-in"></i><span class="nav-link-text">Login</span></a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${pageContext.request.contextPath}/about">
            <i class="fa fa-fw fa-users"></i>
            <span class="nav-link-text">About US</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${pageContext.request.contextPath}/contact">
            <i class="fa fa-fw fa-vcard"></i>
            <span class="nav-link-text">Contact US</span>
          </a>
        </li>
        </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
      
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#loginModal">
            <i class="fa fa-fw fa-sign-in"></i>Login</a>
        </li>
      </ul>
    </div>
  </nav>
   <!-- Login Modal-->
		    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		      <div class="modal-dialog" role="document">
		        <div class="modal-content">
		          <div class="modal-header">
		            <h5 class="modal-title" id="exampleModalLabel">Login with Username and Password</h5>
		            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
		              <span aria-hidden="true">×</span>
		            </button>
		          </div>
		          <div class="modal-body">
		          	<div class="card card-login mx-auto mt-5">
					      <div class="card-header has-primary">Login</div>
					      <div class="card-body">
					      <c:if test="${not empty error}">
								<div class="alert alert-danger">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="alert alert-danger">${msg}</div>
							</c:if>
					      
					        <form name='loginForm' action="<c:url value='/login' />" method='POST'>
					          <div class="form-group">
					            <label for="exampleInputEmail1">Username</label>
					            <input class="form-control" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter Username" name='username'>
					          </div>
					          <div class="form-group">
					            <label for="exampleInputPassword1">Password</label>
					            <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password" name='password'>
					          </div>
					          <div class="form-group">
					            <div class="form-check">
					              <label class="form-check-label">
					                <input class="form-check-input" type="checkbox"> Remember Password</label>
					            </div>
					          </div>
					          <input class="btn btn-primary btn-block" type="submit" value="Login">
					          <input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
					        </form>
					        <div class="text-center">
					          <a class="d-block small mt-3" href="register.html">Register an Account</a>
					          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
					        </div>
					      </div>
					    </div>
					  </div>
		          </div>
		        </div>
		      </div>