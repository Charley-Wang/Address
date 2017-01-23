/**
 * Codes for index.jsp
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
	// clear localStorage
	// localStorage.clear();
	
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