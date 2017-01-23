/**
 * Operations about comments for address
 * by Charley (Xingsheng) Wang
 * email: charleyjava@gmail.com
 * 
 * public variable used: userInfo
 * public variable used: starLevel
 * 
 */

/**
 * Add a comments to the database
 * @param addrID address id for the comment
 */
function addComments(addrID) {

	$.ajax({
		type: 'POST',
		url: 'comments/create',
		data: getCreateComments(addrID),
		success: function(data, textStatus, jqXHR) {
			// change cursor to default
			$("body").css("cursor", "default");
		},
		error: function(jqXHR, textStatus, errorThrown) {
			// change cursor to default
			$("body").css("cursor", "default");
			console.log(textStatus);
		}
	});

}

/**
 * get JSON format from the interface for adding a comment for an address
 * @param addrID address id for the comment
 * @returns JSON format for a message
 */
function getCreateComments(addrID) {
	var dat = "email=" + userInfo.email;
	dat += "&" + "addrID=" + addrID;
	dat += "&" + "comments=" + $('#evaluate').val();
	dat += "&" + "level=" + starLevel;
	return dat;
}

/**
 * Change the selected stars when the mouse hovering on one star
 */
$('.star').hover(function(){
	var frameID = $(this).attr('id');
	var id = parseInt(frameID.substring(4));
	changeStar(id);
})

/**
 * Change the selected stars when the mouse hovering on one star
 * @param num the star number the mouse is hovering
 * @returns public variable (starLevel) is set to the star number the mouse is hovering
 */
function changeStar(num) {
	starLevel = num;
	var src = "resources/star1.png";
	$('#star1').attr('src', src);
	if (num === 1) src = "resources/star0.png";
	$('#star2').attr('src', src);
	if (num === 2) src = "resources/star0.png";
	$('#star3').attr('src', src);
	if (num === 3) src = "resources/star0.png";
	$('#star4').attr('src', src);
	if (num === 4) src = "resources/star0.png";
	$('#star5').attr('src', src);
	if (num === 5) src = "resources/star0.png";
	$('#star6').attr('src', src);
	if (num === 6) src = "resources/star0.png";
	$('#star7').attr('src', src);
}