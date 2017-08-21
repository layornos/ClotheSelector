/**
 * 
 */

function addOutfit() {
	var outfit = $('#outfit').val();
	var occasion = $('#occasion').val();
	var season = $('#season').val();
	var rain = $('rain').val();
	
	
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/clotheselector/outfits/addoutfitservice/"+outfit+"/"+season+"/"+rain+"/"+occasion, false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
}