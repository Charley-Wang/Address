/**
 * Codes for user.jsp
 */

/**
 * userInfo: user information
 * id: user id - a alias name for the user
 * email: real user id identify by her/his email
 * password: password for the current user
 * addrID: the current address ID used for comments
 * address: the current address information
 */
var userInfo = {
	id: "",
	email: "",
	password: "",
	addrID: "",
	address: "",
}

/**
 * Initialization of contact.jsp
 * set userInfo from local storage
 */
$("document").ready(function(){
	// check if browser support window.localStorage
	if (typeof(Storage) == "undefined") {
		alert("Please update your browser to enjoy Image Framer!");
	} else {
		if (localStorage.getItem('address_userInfo') !== null) {
			userInfo = JSON.parse(localStorage.getItem("address_userInfo"));
		}
	}
	
	// show user id
	$('#userNameID').html(userInfo.id);
});

$("document").ready(login);
$("document").ready(checkEmail);
$("document").ready(register);
$("document").ready(findPassword);
$("document").ready(changePassword);
$("document").ready(closeAccount);

/**
 * Event for login
 * @returns change userInfo and re-save it to local storage
 *          change web page to index.jsp
 */
function login() {
	
	$("#login").click(function(evt){
		var email = $('#email_log').val();
		var password = $('#password_log').val();
		var url = 'users/email/' + email + "/password/" + password + "/check";

		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'GET',
			url: url,
			dataType: "text",
			success: function(data) {
				$("body").css("cursor", "default");
				
				state = data.substring(0, 2);
				if (state === "OK") {
					// save userInfo
					userID = data.substring(2);
					userInfo.id = userID;
					userInfo.email = email;
					userInfo.password = password;
					localStorage.setItem("address_userInfo", JSON.stringify(userInfo));
					
					document.location.href = "index.jsp";
				} else {
					alert(data);
				}

			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			},
		});
	});
};

/**
 * Check email exists
 */
function checkEmail() {
	$("#email_reg").focusout(function(evt){
		var email = $(this).val();
		var url2 = 'users/email/' + email + '/check';
		
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'GET',
			url: url2,
			dataType: "text",
			success: function(data) {
				$("body").css("cursor", "default");
				console.log(data);
				if (data === "exists") {
					$('#check_reg_y').hide();
					$('#check_reg_n').show();									
				} else {
					$('#check_reg_y').show();
					$('#check_reg_n').hide();
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			},
		});
	});
};

/**
 * Register a new user
 * @returns change userInfo and re-save it to local storage
 *          change web page to index.jsp
 *          Send data to database
 */
function register() {
	$("#register").click(function(evt){
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'POST',
			url: 'users/adduser',
			data: form2JSON_reg(),
			success: function(data, textStatus, jqXHR) {
				$("body").css("cursor", "default");
				state = data.substring(0, 2);
				if (state === "OK") {
					userInfo.id = $('#username_reg').val();
					userInfo.email = $('#email_reg').val();
					userInfo.password = $('#password_reg').val();
					localStorage.setItem("address_userInfo", JSON.stringify(userInfo));
					
					document.location.href = "index.jsp";
				} else {
					alert(data);
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
	});
};

/**
 * Event for finding the password
 * Send data to database
 */
function findPassword() {
	$("#findpassword").click(function(evt){
		
		var email = $('#email_find').val();
		var url = 'users/findemail/' + email + "/check";
		
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'GET',
			url: url,
			dataType: "text",
			success: function(data) {
				$("body").css("cursor", "default");
				state = data.substring(0, 2);
				if (state === "OK") {
					alert("We will email your password to you. Thank you.");
				} else {
					alert(data);
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			},
		});
	});
};

/**
 * Event for changing password
 * Send data to database
 */
function changePassword() {
	$("#changePassword").click(function(evt){
		
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		var url = "users/newpass";
		var dat = "email=" + $('#email_chg').val()
		          +"&password=" + $('#oldpassword').val()
		          +"&message=" + $('#newpassword').val();
		
		$.ajax({
			type: 'POST',
			url: url,
			data: dat,
			success: function(data, textStatus, jqXHR) {
				$("body").css("cursor", "default");
				alert(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
	});
};

/**
 * Close the account
 * Send data to database
 */
function closeAccount() {
	$("#closeAccount").click(function(evt){
		
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'POST',
			url: "users/delaccount",
			data: form2JSON_close(),
			success: function(data, textStatus, jqXHR) {
				$("body").css("cursor", "default");
				alert(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
	});
};

/**
 * Set format from the interface for registering a user
 */
function form2JSON_reg() {
	return "userID=" + $('#username_reg').val()
		 + "&email=" + $('#email_reg').val()
		 + "&password=" + $('#password_reg').val()
		 + "&gender=" + $('.gender:checked').val()
		 + "&notice=" + $('.notice:checked').val()
		 + "&message=" + $('#message_reg').val();
}

/**
 * Set format from the interface for closing a user account
 */
function form2JSON_close() {
	return "email=" + $('#email_close').val()
		   +"&password=" + $('#password_close').val()
		   +"&message=" + $('#message_close').val();
}