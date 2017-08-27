package de.layornos.clotheselector.pagebuilder;

import java.util.List;

public class SlideshowBuilder {
	
	public static String createSlideshowHTML(List<String> imagePaths) {
	    String html = "<html><head><meta charset=\"UTF-8\">"+
	    		"<title>ClotheSelector - Outfits</title>"+
	    		"<script src=\"/ClotheSelector/jquery.js\"></script>\n" +
	    		"<script src=\"/ClotheSelector/trashButton.js\"></script>\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\">\n" + 
				"<title>Clothe Selector</title>\n"+
	    		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">" +
	    		"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
				"<link rel=\"stylesheet\" href=\"/ClotheSelector/all.css\">\n" +
				"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" + 
	    		"</head>\n";
	    html += "<body>\n";
		html += "<div class=\"w3-container w3-text-teal\"><h1>Clothe Selector</h1></div>";	
	    html += "<div class=\"w3-container\"><h2>Deine Outfits</h2>\n";
	    html += "<div class=\"w3-display-container\">\n";
	    if(imagePaths.isEmpty())
	    	html += "<div class=\"w3-container w3-display-middle\"><h5>Du hast noch <br>keine passenden Outfits <br>hochgeladen!</h5></div>\n";
	    for(String path : imagePaths) {
	    	html += "\t<div name=\""+path+"\" class=\"w3-display-container mySlides\">\n\t\t<img src=\""+path+"\" style=\"width:100%\">\n\t\t\t<div class=\"w3-display-bottomleft w3-large w3-container w3-padding-16 w3-black\">"+path+"\n\t\t\t</div>\n\t\t</div>\n";
	    }
	    html += "<button class=\"w3-button w3-display-left w3-tear\" onclick=\"plusDivs(-1)\">&#10094;</button>\n" +
	    		"<button class=\"w3-button w3-display-right w3-tear\" onclick=\"plusDivs(1)\">&#10095;</button>\n" +
	    		"</div>\n"+
	    		"<div class=\"w3-display-container\">"+ 
	    		"<button class=\"w3-button w3-display-right w3-tear\" title=\"Delete\" onclick=\"return goto()\">Delete</button>\n" + 
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
	    html += "</div></body></html>\n";
		return html;
	}
}
