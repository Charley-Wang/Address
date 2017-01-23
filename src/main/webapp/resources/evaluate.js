/**
 * Code for evaluate.jsp
 */

// default star level for the comments
var starLevel = 4;

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

$("document").ready(findAddress);
$("document").ready(selectAddress);
$("document").ready(addAddress);

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
			if (userInfo.addrID !== "" && userInfo.addrID !== null) {
				loadComments(userInfo.address, userInfo.addrID);
			}
		}
	}
	
	// show user id
	$('#userNameID').html(userInfo.id);
});

/**
 * Event for submit of adding a new comment
 * Refresh the comments for the current address (userInfo.address, userInfo.addrID)
 */
function addAddress() {
	$("#submit").click(function(evt){
		// change cursor to wait
		$("body").css("cursor", "progress");
		addComments(userInfo.addrID);
		// refresh comments
		loadComments(userInfo.address, userInfo.addrID);
	});
}

/**
 * Events for finding addresses
 */
function findAddress() {
	$("#find").click(function(evt){
		submitAddress();
	});
	$('#keys').keydown(function(event){
	    if(event.keyCode == 13) {
	    	event.preventDefault();
	    	submitAddress();
	    }
	});
}

/**
 * Request address according to input "#keys"
 * Refresh the results - addresses
 */
function submitAddress() {
	// change cursor to wait
	$("body").css("cursor", "progress");

	$('#addressTable').empty();
	
	$.ajax({
		type: 'GET',
		url: 'address/find/' + $('#keys').val() + "/",
		success: function(data, textStatus, jqXHR) {
			// change cursor to default
			$("body").css("cursor", "default");
			
			// refresh addresses
			$('#addressTable').append(data);
			
			// this is very important to dynamically bind an event
			selectAddress();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// change cursor to default
			$("body").css("cursor", "default");
			console.log(textStatus);
		}
	});
}

/**
 * Event for hovering a row
 * Refresh comments
 * Update public variable userInfo and re-save to local storage
 */
function selectAddress() {
	$("tr").click(function(evt){
		var rowID = $(this).attr('id');
		var addrID = $('#' + rowID + " #ai").text();

		// update address shown in the jsp
		var dat = $(this).children("td").map(function() {
	        return $(this).text();
	    }).get();
		var info = dat[1] + ", " + dat[3];
		
		// update public variable
		userInfo.addrID = addrID;
		userInfo.address = info;
		localStorage.setItem("address_userInfo", JSON.stringify(userInfo));
		
		// load comments
		loadComments(info, addrID);
	});
}

/**
 * Load comments according to addrID
 * @param info address information
 * @param addrID address ID
 */
function loadComments(info, addrID) {
	$('#selAddress').html(info);
	$('#selAddress2').html(info);
		
	$('#commentsTable').empty();
	$("body").css("cursor", "progress");

	$.ajax({
		type: 'GET',
		url: 'comments/addrID/' + addrID + "/",
		success: function(data, textStatus, jqXHR) {
			// change cursor to default
			$("body").css("cursor", "default");
			
			// refresh comments
			$('#commentsTable').append(data);
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// change cursor to default
			$("body").css("cursor", "default");
			console.log(textStatus);
		}
	});
}