package de.layornos.clotheselector.pagebuilder;

import java.util.List;

public class SlideshowBuilder {
	
	public static String createSlideshowHTML(List<String> imagePaths) {
	    String html = "<html><head><meta charset=\"UTF-8\"><title>ClotheSelector - Outfits</title><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></head>\n";
	    html += "<body>\n"
	    		+ "<script src=\"/ClotheSelector/jquery.js\"></script>\n"
	    		+ "<script src=\"/ClotheSelector/trashButton.js\"></script>\n";
		html += "	<div class=\"w3-container\"><h1>Clothe Selector</h1></div>";	
	    html += "<div class=\"w3-container\"><h2>Deine Outfits</h2><p>\n";
	    html += "<div class=\"w3-content w3-display-container\">\n";
	    if(imagePaths.isEmpty())
	    	html += "<h3>Du hast noch keine passenden Outfits hochgeladen!</h3>\n";
	    for(String path : imagePaths) {
	    	html += "\t<div name=\""+path+"\" class=\"w3-display-container mySlides\">\n\t\t<img src=\""+path+"\" style=\"width:100%\">\n\t\t\t<div class=\"w3-display-bottomleft w3-large w3-container w3-padding-16 w3-black\">"+path+"\n\t\t\t</div>\n\t\t</div>\n";
	    }
	    html += "<button class=\"w3-button w3-display-left w3-black\" onclick=\"plusDivs(-1)\">&#10094;</button>\n" + 
	    		"<button class=\"w3-button w3-display-right w3-black\" onclick=\"plusDivs(1)\">&#10095;</button>\n" + 
	    		"<button class=\"w3-button w3-display-right w3-blac\" title=\"Delete\" onclick=\"return goto()\">Delete</button>\n" + 
	    		"</div>";
	    
	    html += "<script>\n" + 
	    		"var slideIndex = 1;\n" + 
	    		"showDivs(slideIndex);\n" + 
	    		"\n" + 
	    		"function plusDivs(n) {\n" + 
	    		"  showDivs(slideIndex += n);\n" + 
	    		"}\n" + 
	    		"\n" + 
	    		"function showDivs(n) {\n" + 
	    		"  var i;\n" + 
	    		"  var x = document.getElementsByClassName(\"mySlides\");\n" + 
	    		"  if (n > x.length) {slideIndex = 1}    \n" + 
	    		"  if (n < 1) {slideIndex = x.length}\n" + 
	    		"  for (i = 0; i < x.length; i++) {\n" + 
	    		"     x[i].style.display = \"none\";  \n" + 
	    		"  }\n" + 
	    		"  x[slideIndex-1].style.display = \"block\";  \n" + 
	    		"}\n" + 
	    		"</script>";
	    html += "</body></html>\n";
		return html;
	}
}
