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
                
                <!-- .................. Login Form ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2 style="color:#FF00FF;">Login<small>Click to validate</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>
                      <label for="email">Email * :</label>
                      <input type="email" id="email_log" class="form-control" name="email" data-parsley-trigger="change" required />
                      <label for="password">Password * :</label>
                      <input type="password" id="password_log" class="form-control" name="password" required />
                      <br/>
                      <span id="login" class="btn btn-primary">Login</span>
                    </form>
                    <!-- end form for validations -->
                  </div>
                  
                </div>
			
				<!-- .................. Registration Form ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2 style="color:#FF00FF;">Registration<small>Click to validate</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>

                      <label for="email_reg">Email * :
                      <i class="fa fa-check" id="check_reg_y" style="display:none;font-size:15px;color:green;"></i>
                      <i class="fa fa-times" id="check_reg_n" style="display:none;font-size:15px;color:red;"></i>
                      </label>
                      <input type="email" id="email_reg" class="form-control" name="email" data-parsley-trigger="change" required />
                      <label for="username_reg">Preferred Name * :</label>
                      <input type="text" id="username_reg" class="form-control" name="username" required />
                      <label for="password_reg">Password * :</label>
                      <input type="password" id="password_reg" class="form-control" name="password" required />

                      <label>Gender *:</label>
                      <div class="radio radio-info">
                        <input type="radio" name="gender" class="gender" value="F" checked />
                        <label>Female</label>
                      </div>
                      <div class="radio radio-info">
                        <input type="radio" name="gender" class="gender" value="M" />
                        <label>Male</label>
                      </div>
                      <div class="radio radio-info">
                        <input type="radio" name="gender" class="gender" value="O" />
                        <label>Other</label>
                      </div>

					  <label>Email Notifications about Features, Comments, and Updates: *</label>
					  <div class="radio radio-info">
                        <input type="radio" name="notice" class="notice" value="T" checked />
                        <label>Notice</label>
                      </div>
                      <div class="radio radio-info">
                        <input type="radio" name="notice" class="notice" value="F" />
                        <label>Not Notice</label>
                      </div>
                      
                      <label for="message">Message :</label>
                      <textarea id="message_reg" class="form-control" name="message" data-parsley-trigger="keyup"></textarea>
                      <br/>
                      <span id="register" class="btn btn-primary">Register</span>
                    </form>
                    <!-- end form for validations -->
                  </div>

                </div>

				<!-- .................. Find Password ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2 style="color:#FF00FF;">Find Password</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>
                      <label for="email">Email * :</label>
                      <input type="email" id="email_find" class="form-control" name="email" data-parsley-trigger="change" required />
                      <br/>
                      <span id="findpassword" class="btn btn-primary">Send Password</span>
                    </form>
                    <!-- end form for validations -->
                  </div>

                </div>
                
                <!-- .................. Change Password ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2 style="color:#FF00FF;">Change Password<small>Click to validate</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>
                      <label for="email">Email * :</label>
                      <input type="email" id="email_chg" class="form-control" name="email" data-parsley-trigger="change" required />
                      <label for="oldpassword">Old Password * :</label>
                      <input type="password" id="oldpassword" class="form-control" name="oldpassword" required />
                      <label for="newpassword">New Password * :</label>
                      <input type="password" id="newpassword" class="form-control" name="newpassword" required />
                      <br/>
                      <span id="changePassword" class="btn btn-primary">Change Password</span>
                    </form>
                    <!-- end form for validations -->

                  </div>
                </div>
                
                <!-- .................. Close Account ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2 style="color:#FF00FF;">Close Account<small>Click to validate</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>
                      <label for="email_close">Email * :</label>
                      <input type="email" id="email_close" class="form-control" name="email" data-parsley-trigger="change" required />
                      <label for="password_close">Password * :</label>
                      <input type="password" id="password_close" class="form-control" name="password" required />
				      <label for="message">Message * :</label>
                      <textarea id="message_close" class="form-control" name="message" data-parsley-trigger="keyup" required></textarea>
                      <br/>
                      <span id="closeAccount" class="btn btn-primary">Close Account</span>
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
	<script src="resources/user.js"></script>
	
  </body>
</html>
