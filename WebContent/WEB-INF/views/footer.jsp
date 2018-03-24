<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

 <footer  class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Local Rental Transport 2018  </small>
          &nbsp;&nbsp&nbsp&nbsp&nbsp
          <span> <%
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("E  yyyy-MM-dd ");
         out.print(  ft.format(dNow) ); %></span>
          &nbsp;
          <i class="fa fa-clock-o" color:red"></i>
          <span class="clock font-weight-bold font-italic"></span>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <form action="logout" method="get">
				 <input class="btn btn-primary" type="submit" value="Logout" />
				 <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
				</form>
          </div>
        </div>
      </div>
    </div>