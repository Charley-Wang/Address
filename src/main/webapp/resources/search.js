var marker = null;
var lat="", lng="";

var userInfo = {
	id: "",
	email: "",
	password: "",
	addrID: "",
	address: "",
}

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

$("document").ready(state);
$("document").ready(getAddress);

function state() {
	var state = ["", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", 
		         "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", 
		         "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", 
		         "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", 
		         "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"];
	var i;
	for (i in state) {
		$('#state').append('<option value="' + state[i] + '">' + state[i] + '</option>');
	}
}

function getSearch() {
	var sep = "&"
	var dat = "lat=" + lat;
	dat += sep + "lng=" + lng;
	dat += sep + "address=" + $('#address1').val();
	dat += sep + "miles=" + $('#miles').val();
	dat += sep + "type1=" + $('#type1').val();
	dat += sep + "type2=" + $('#type2').val();
	dat += sep + "state=" + $('#state').val();
	return dat;
}

function getSearch3() {
	var dat = lat;
	dat += ";" + lng;
	dat += ";" + $('#address1').val();
	dat += ";" + $('#miles').val();
	dat += ";" + $('#type1').val();
	dat += ";" + $('#type2').val();
	dat += ";" + $('#state').val();
	return dat;
}

function getSearch2() {
	var dat = "{lat:'" + lat + "',";
	dat += "lng:'" + lng + "',";
	dat += "address:'" + $('#address1').val() + "',";
	dat += "miles:'" + $('#miles').val() + "',";
	dat += "type1:'" + $('#type1').val() + "',";
	dat += "type2:'" + $('#type2').val() + "',";
	dat += "state:'" + $('#state').val() + "'}";
	return dat;
}

function getAddress() {
	$("#submit").click(function(evt){
		// change cursor to wait
		$("body").css("cursor", "progress");
		var dat = getSearch();
		console.log(dat);

		$('#addressTable').empty();
		$.ajax({
			type: 'GET',
			url: 'address/search/' + dat + "/",
			data: dat,
			success: function(data, textStatus, jqXHR) {
				// change cursor to default
				$("body").css("cursor", "default");
				$('#addressTable').append(data);
				// trigger click events
				selectAddress()
			},
			error: function(jqXHR, textStatus, errorThrown) {
				// change cursor to default
				$("body").css("cursor", "default");
				console.log(textStatus);
			}
		});
		
	});
};

function selectAddress() {
	$("tr").click(function(evt){
		
		var rowID = $(this).attr('id');
		//var addrID = $('#' + rowID + " #ai").text();

		// update address shown in the jsp
		var dat = $(this).children("td").map(function() {
	        return $(this).text();
	    }).get();
		var info = dat[1] + ", " + dat[3];
		
		// update public variable
		userInfo.addrID = dat[0].trim();
		userInfo.address = info;
		localStorage.setItem("address_userInfo", JSON.stringify(userInfo));
		
		document.location.href = "evaluate.jsp";
	});
}