/**
 * 
 */

function addOutfit() {
	var outfit = $("#outfit")[0].value;
	console.lol(outfit);
	var occasion = $('#occasion').value;
	var season = $('#season').value;
	var rain = $('rain').value;
	
	
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/clotheselector/outfits/addoutfitservice/"+outfit+"/"+season+"/"+rain+"/"+occasion, false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
}