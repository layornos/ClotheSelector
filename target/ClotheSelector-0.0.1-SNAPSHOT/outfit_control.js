/**
 * 
 */

function addOutfit() {
	var outfit = $('#outfit').val();
	var occasion = $('#occasion').val();
	var season = $('#season').val();
	var rain = $('#rain').is(':checked');
	if(rain){
		rain = 1;
	} else {
		rain = 0;
	} 
	
		
//    console.log(rain);
	
	var url = "http://192.168.1.10:8080/ClotheSelector/outfits/addoutfitservice/"+outfit+"/"+season+"/"+rain+"/"+occasion;
	console.log(url);
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);
    xhttp.setRequestHeader("Content-type", "text/plain");
    xhttp.send();
    var response = (xhttp.responseText);
    console.log(response);
}



//http://127.0.0.1:8080/ClotheSelector/outfits/addoutfitservice/OutfitIAEIAE/SUMMER/1/Freizeit
//http://localhost:8080/clotheselector/outfits/addoutfitservice/Stuff/       WINTER/0/Freizeit