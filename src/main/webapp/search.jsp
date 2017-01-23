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
                
                <!-- .................. step 1 ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2>Step 1: Choose Zipcode (Optional)</h2>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    <form id="demo-form" data-parsley-validate>
                      <input type="text" id="zipcode" class="form-control" name="zipcode" data-parsley-trigger="change" value="17033" required />
                      <br/>
                      <span id="getmap" class="btn btn-primary">Get Map</span>
                    </form>
                    <!-- end form for validations -->

                  </div>
                </div>
				<!-- ...................................................... -->
				
				
				<!-- .................. step 2 ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2>Step 2: Place Interested Location (Optional)
                    <small>Click on map to select an interested location</small></h2>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <div id="map" style="width:100%;height:500px"></div>
                  </div>
                </div>
				<!-- ...................................................... -->

				<!-- .................. step 3 ........................ -->
				<div class="x_panel">
				
                  <div class="x_title">
                    <h2>Step 3: Search Parameters</h2>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                    <!-- start form for validation -->
                    
					<form id="demo-form" data-parsley-validate>
                      <label for="address1">Address :</label>
                      <input type="text" id="address1" class="form-control" name="address1" data-parsley-trigger="change" required />
                      <br/>

                      <label for="state">State :</label>
                      <select id="state" class="form-control" required>
                      </select>
                      <br/>
                      
                      <label for="type1">Type :</label>
                      <select id="type1" class="form-control" required>
                        <option value=""></option>
                        <option value="Accommodation">Accommodation</option>
						<option value="Food">Food</option>
						<option value="Fuel">Fuel</option>
						<option value="Transit">Transit</option>
						<option value="Shopping">Shopping</option>
						<option value="Bank or ATM">Bank/ATM</option>
						<option value="Parking">Parking</option>
						<option value="Entertainment">Entertainment</option>
						<option value="Recreation">Recreation</option>
						<option value="Attractions">Attractions</option>
						<option value="Hospitals">Hospitals</option>
						<option value="Community">Community</option>
						<option value="Auto Services">Auto Services</option>
						<option value="Other">Other</option>
                      </select>
                      <br/>
                      
                      <label for="type2">Sub Type :</label>
                      <select id="type2" class="form-control" required>
                      </select>
                      <br/>
                      
                      <label for="miles">Within Miles to the Interested Location :</label>
                      <input type="text" id="miles" class="form-control" name="miles" data-parsley-trigger="change" required />
                      <br/>
                      
                      <span id="submit" class="btn btn-primary">Search</span>
                    </form>

                    <!-- end form for validations -->

                  </div>
                </div>
				<!-- ...................................................... -->

				<!-- .................. show address ........................ -->
				<div class="x_panel">
                  <div class="x_title">
                    <h2>Results</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table class="table table-hover" id="addressTable"></table>
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
	<script src="resources/search.js"></script>
	<script src="resources/interface.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzo2xlsfuIAlDJTyGRjqJCPLRCsmiwu3g&callback=myMap"></script>
	
  </body>
</html>
