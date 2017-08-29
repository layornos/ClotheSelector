function gotoIndex(){
	window.location.href = "/ClotheSelector/Index";
}

function goto(){
	var nameOfDiv = $(".mySlides").attr('name');
	nameOfDiv = nameOfDiv.replace("../../", "");
	nameOfDiv = nameOfDiv.replace(".jpg", "");
	nameOfDiv = nameOfDiv.substring(nameOfDiv.indexOf('\\')+1, nameOfDiv.indexOf('_'));
	
	$.ajax({
		   type: "GET",
		   url: "/ClotheSelector/outfits/deleteoutfitservice/"+nameOfDiv,
		   contentType: "text/plain",
		   success: function (msg) {//On Successfull service call   
		        console.log(msg);
		        location.reload(true);
		    },
		    error: function (xhr) { console.log(xhr.responseText); }
		});
	
	
//    var xhttp = new XMLHttpRequest();
//    xhttp.open("POST", "/ClotheSelector/outfits/deleteoutfitservice/"+nameOfDiv, false);
//    xhttp.setRequestHeader("Content-type", "text/plain");
//    xhttp.send();
//    var response = xhttp.responseText;
}

function gotoAddOutfit(){
	location.href = "addOutfit";
}

function gotoAllOutfits(){
	location.href = "showOutfits";
}

function uploadImage(){
	if(allFormElementsFilled()){
		document.forms[0].submit();
	}
}

function allFormElementsFilled(){
	if(($("#occasion").val().length == 0) &&
			($("#outfit").val().length == 0))
		return false;
	else
		return true;
}