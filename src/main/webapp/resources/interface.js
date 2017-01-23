/**
 * Set interface about google earth API
 * Set interface about address types
 */

$("document").ready(changeZipcode);

/**
 * Set map to the default location (Hershey, PA)
 */
function myMap() {
	changeMapLatLng(40.271823, -76.637562);
}

/**
 * Change map location according to (lat, lng)
 * @param lat latitude of the map
 * @param lng longitude of the map
 */
function changeMapLatLng(lat, lng) {
	var mapCanvas = document.getElementById("map");
	var mapOptions = {
		center: new google.maps.LatLng(lat, lng), 
		zoom: 12
	}
	var map = new google.maps.Map(mapCanvas, mapOptions);
	map.addListener('click', function(e) {
		placeMarker(e.latLng, map);
	});
}

/**
 * Place marker to the map according to location
 * @param location
 * @param map google earth map
 * @returns set the public variable (lat, lng)
 */
function placeMarker(location, map) {
	if (marker !== null) {
		marker.setMap(null);
	}
	marker = new google.maps.Marker({
		position: location, 
		map: map
	});
	lat = location.lat();
	lng = location.lng();
}

/**
 * Change location of the map after changing zipcode
 */
function changeZipcode() {
	$("#zipcode").focusout(function(evt){
		var zipcode = $(this).val();
		
		// change cursor to wait
		$("body").css("cursor", "progress");
		
		$.ajax({
			type: 'GET',
			url: '/Address/getLatLng/' + zipcode,
			dataType: "text",
			success: function(data) {
				$("body").css("cursor", "default");
				if (data === "") {
					alert("Zipcode is invalid!");
				} else {
					// get lat and lng for the current zipcode
					var txts = data.split(",");
					
					// change map location to (lat, lng)
					changeMapLatLng(Number(txts[0]), Number(txts[1]));
					
					// change default address
					var address = txts[2] + ", " + txts[3] + " " + zipcode;
					$("#address2").val(address);
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
 * Change type2 drop down selection when type1 changes
 */
$("#type1").change(function() {
	var type1 = $('#type1 option:selected').val();
	$('#type2').empty();
	if (type1 === "Accommodation") {
		accommodation();
	} else if (type1 === "Food") {
		food();
	} else if (type1 === "Transit") {
		transit();
	} else if (type1 === "Shopping") {
		shopping();
	} else if (type1 === "Entertainment") {
		entertainment();
	} else if (type1 === "Recreation") {
		recreation();
	} else if (type1 === "Attractions") {
		attractions();
	} else if (type1 === "Community") {
		community();
	} else if (type1 === "Auto Services") {
		autoservices();
	}
})

function accommodation() {
	var accs = ["Hotel","Motel","Mansion","Lodge","Resort","Apartment",
		        "Inn","Manor","Pension","Townhouse","Pod","Relais",
		        "Castle","Palace","Farmhouse","Parador","Masia","Other"];
	var i;
	for (i in accs) {
		$('#type2').append('<option value="' + accs[i] + '">' + accs[i] + '</option>');
	}
}

function food() {
	var foods = ["American","Asian","Bagel or Donut","Barbecue",
	             "British Isles","Cafe or Diner","Chinese","Deli or Bakery",
	             "Fast Food","French","German","International","Italian","Other"];
	var i;
	for (i in foods) {
		$('#type2').append('<option value="' + foods[i] + '">' + foods[i] + '</option>');
	}
}

function transit() {
	var transits = ["Auto Rental","Ground Transportation","Air Transportation","Transit Service"];
	var i;
	for (i in transits) {
		$('#type2').append('<option value="' + transits[i] + '">' + transits[i] + '</option>');
	}
}

function shopping() {
	var shops = ["Apparel","Computer","Convenience","Department","General Merchandise",
                 "Grocery","Home Furnishings","House and Garden","Pharmacy","Shopping Center",
                 "Specialty Retail","Other"];
	var i;
	for (i in shops) {
		$('#type2').append('<option value="' + shops[i] + '">' + shops[i] + '</option>');
	}
}

function entertainment() {
	var enters = ["Bar or Nightclub","Casino","Live Theater","Movie Theater"];
	var i;
	for (i in enters) {
		$('#type2').append('<option value="' + enters[i] + '">' + enters[i] + '</option>');
	}
}

function recreation() {
	var recreations = ["Amusement or Theme Park","Arena or Track","Bowling Center",
                       "Golf Course","Ice Skating","Park or Garden",
                       "Skiing Center or Resort","Ice Skating","Park or Garden",
                       "Sports or Fitness Center","Other"];
	var i;
	for (i in recreations) {
		$('#type2').append('<option value="' + recreations[i] + '">' + recreations[i] + '</option>');
	}
}

function attractions() {
	var attractions = ["Amusement or Theme Park","Arena or Track","Hall or Auditorium",
		               "Landmark","Museum or Historical","Park or Garden",
		               "Winery","Zoo or Aquarium","Other"];
	var i;
	for (i in attractions) {
		$('#type2').append('<option value="' + attractions[i] + '">' + attractions[i] + '</option>');
	}
}

function community() {
	var community = ["Bank or ATM","City Hall","Community Center","Court House",
                     "Fire Department","Government Office","Library","Place of Worship",
                     "Police Station","Post Office","School","Police Station",
                     "Utility","Other"];
	var i;
	for (i in community) {
		$('#type2').append('<option value="' + community[i] + '">' + community[i] + '</option>');
	}
}

function autoservices() {
	var autoservices = ["Auto Rental","Auto Repair","Automobile Club",
                        "Car Wash","Dealer or Auto Parts","Rest Area or Tourist Info",
                        "Truck Stop","Wrecker Service","Other"];
	var i;
	for (i in autoservices) {
		$('#type2').append('<option value="' + autoservices[i] + '">' + autoservices[i] + '</option>');
	}
}
