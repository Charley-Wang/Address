<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Free online Image Framer</title>
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome.css" rel="stylesheet">
    
    <!-- Ion.RangeSlider -->
    <link href="resources/bootstrap/css/ion.rangeSlider.css" rel="stylesheet">
    <link href="resources/bootstrap/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
	<!-- custom.css has been modified by Charley Wang -->    
    <link href="resources/custom.css" rel="stylesheet">
 	<link href="resources/index.css" rel="stylesheet">
 	<link href="resources/user.css" rel="stylesheet">
	
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">

        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">

			<!-- logo -->
            <div class="navbar nav_title" style="border: 0;" id="logoID">
              <a href="index.jsp" class="site_title">
                <i class="fa fa-comment"></i>
                <span>Evaluate Address</span>
              </a>
            </div>
            <!-- logo -->

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="resources/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2 id="userNameID">User</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

			  <!-- general menu -->
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li><a href="index.jsp"><i class="nav child_menu fa fa-home"></i>Home</a></li>
                  <li><a href="create.jsp"><i class="nav child_menu fa fa-list-alt"></i>Create Address</a></li>
                  <li><a href="evaluate.jsp"><i class="nav child_menu fa fa-comments"></i>Evaluate Address</a></li>
                  <li><a href="search.jsp"><i class="nav child_menu fa fa-search"></i>Search Address</a></li>
                  <li><a href="user.jsp"><i class="nav child_menu fa fa-user"></i>User Center</a></li>
                  <li><a href="contact.jsp"><i class="nav child_menu fa fa-envelope"></i>Contact Us</a></li>
                </ul>
              </div>
              <!-- general menu -->

            </div>
            <!-- /sidebar menu -->

          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu yellow-color">
            <div class="col-md-4">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
            </nav>
            </div>
            <span class="topTitleID">Free Online Address Evaluation</span>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        
        <div class="right_col blue-color" role="main">
          <div class="row">
            <div id="mainContent">
                
                <!-- .................. Contact Us ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2>Contact Us<small>Click to validate</small></h2>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <div>Welcome to contact us. 
                    If you have any question, suggestion, and comment, 
                    please directly email us via email charleyjava AT gmail DOT com 
                    or send us a message. Thank you.</div> <br/>
                    <form id="demo-form" data-parsley-validate>
                      <label for="email">Email * :</label>
                      <input type="email" id="email" class="form-control" name="email" data-parsley-trigger="change" required />
				      <label for="message">Message * :</label>
                      <textarea id="message" class="form-control" name="message" data-parsley-trigger="keyup" required></textarea>
                      <br/>
                      <span id="contact" class="btn btn-primary">Send Message</span>
                    </form>
                    <!-- end form for validations -->

                  </div>
                </div>
				<!-- ...................................................... -->
				
            </div>
          </div>
        </div>
        
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Please respect the rights of the content creator. 
			All text and images are copyright of the rights holder. 
			See our privacy policy.
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="resources/jquery.js"></script>
    <!-- Bootstrap -->
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- Ion.RangeSlider -->
    <script src="resources/bootstrap/js/ion.rangeSlider.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="resources/custom.js"></script>

	<!-- Scripts for Image Framer -->
	<script src="resources/contact.js"></script>
	
  </body>
</html>
