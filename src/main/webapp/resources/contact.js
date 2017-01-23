/**
 * Code for contact.jsp
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

$("document").ready(contact);

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

/**
 * Event for clicking "contact" button
 * Send message to database
 * 
 */
function contact() {
	$("#contact").click(function(evt){
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'POST',
			url: 'users/contact',
			data: form2JSON(),
			success: function(data, textStatus, jqXHR) {
				// change cursor to default
				$("body").css("cursor", "default");
				alert("Thank you for contacting us." + data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				// change cursor to default
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
	});
};

function form2JSON() {
	return "email=" + $('#email').val() + "&message=" + $('#message').val();
}