/**
 * Codes for create.jsp
 */

// Marker for google earth API
var marker = null;
// Latitude and longitude for marker position of google earth API
var lat, lng;
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

$("document").ready(createAddress);
$("document").ready(accommodation);

/**
 * Create an address from the interface
 * Send data to the database
 * @returns Change the public variable userInfo and re-save to local storage
 */
function createAddress() {
	$("#submit").click(function(evt){
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'POST',
			url: 'address/create',
			data: getCreateAddress(),
			success: function(data, textStatus, jqXHR) {
				// add comments
				addComments(data);
				// change local storage
				userInfo.address = $('#address1').val() + ", " + $('#address2').val() + ", "
				                 + $('#type1').val() + ", " + $('#type2').val();
				userInfo.addrID = data;
				localStorage.setItem("address_userInfo", JSON.stringify(userInfo));
				document.location.href = "evaluate.jsp";
			},
			error: function(jqXHR, textStatus, errorThrown) {
				// change cursor to default
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
		
	});
};

/**
 * Get JSON format from the interface for a new address
 * @returns JSON format for a new address
 */
function getCreateAddress() {

	var dat = "email=" + userInfo.email;
	dat += "&" + "zipcode=" + $('#zipcode').val();
	dat += "&" + "lat=" + lat;
	dat += "&" + "lng=" + lng;
	dat += "&" + "address1=" + $('#address1').val();
	dat += "&" + "address2=" + $('#address2').val();

	var sc = getCityState($('#address2').val());
	dat += "&" + "state=" + sc.state;
	dat += "&" + "city=" + sc.city;
	dat += "&" + "type1=" + $('#type1').val();
	dat += "&" + "type2=" + $('#type2').val();
	
	dat += "&" + "company=" + $('#fname').val();
	dat += "&" + "website=" + $('#website').val();
	dat += "&" + "introduction=" + $('#introduce').val();
	
	return dat;
}

/**
 * get state and city from address like "Hershey    ,PA  17033"
 * @returns {city Hershey: , state : PA}
 */
function getCityState(address) {
	var str = address;
	var n = str.search(/( +| *, *)(AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY)( +| *, *)[0-9]{5}/g);
    var city = str.substring(0, n);
    var rest = str.substring(n);
    n = rest.search(/(AK|AL|AR|AZ|CA|CO|CT|DC|DE|FL|GA|HI|IA|ID|IL|IN|KS|KY|LA|MA|MD|ME|MI|MN|MO|MS|MT|NC|ND|NE|NH|NJ|NM|NV|NY|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VA|VT|WA|WI|WV|WY)( +| *, *)[0-9]{5}/g);
    var state = rest.substring(n, n + 2);
    return {city : city, state : state};
}