package de.layornos.clotheselector.pagebuilder;

import java.util.List;

public class SlideshowBuilder {
	
	public static String createSlideshowHTML(List<String> imagePaths) {
	    String html = "<html>\r\n" + 
	    		"<head>\r\n" + 
	    		"<script src=\"/ClotheSelector/jquery.js\"></script>\r\n" + 
	    		"<script src=\"/ClotheSelector/trashButton.js\"></script>\r\n" + 
	    		"<meta charset=\"UTF-8\">\r\n" + 
	    		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	    		"<link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\">\r\n" + 
	    		"<title>Clothe Selector</title>\r\n" + 
	    		"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
	    		"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n" + 
	    		"<link rel=\"stylesheet\" href=\"/ClotheSelector/all.css\">\r\n" + 
	    		"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n" + 
	    		"</head>\r\n" + 
	    		"<body>\r\n" + 
	    		"<div class=\"w3-container w3-text-teal\">\r\n" + 
	    		"  <h1>Clothe Selector</h1>\r\n" + 
	    		"</div>\r\n" + 
	    		"<div class=\"w3-container\">\r\n" + 
	    		"  <h2>Your Outfits</h2>\r\n" + 
	    		"</div>"+
	    		"<div class=\"w3-container\">";
	    if(imagePaths.isEmpty())
	    	html += "<div class=\"w3-display-middle w3-center\">\r\n" + 
	    			"  <h5>No Outfits online!</h5>\r\n" + 
	    			"</div>";
	    for(String path : imagePaths) {
	    	html += "\t<div name=\""+path+"\" class=\"w3-display-container mySlides\">\n\t\t<img src=\""+path+"\" style=\"width:100%\">\n\t\t\t<div class=\"w3-display-bottomleft w3-large w3-container w3-padding-16 w3-black\">"+path+"\n\t\t\t</div>\n\t\t</div>\n";
	    }
	    html += "  <button class=\"w3-button w3-display-left w3-teal\" onclick=\"plusDivs(-1)\">&#10094;</button>\r\n" + 
	    		"  <button class=\"w3-button w3-display-right w3-teal\" onclick=\"plusDivs(1)\">&#10095;</button>\r\n" + 
	    		"</div>\r\n" + 
	    		"<div class=\"w3-container\" style=\"width:100%\">\r\n" + 
	    		"\r\n" + 
	    		"  <button class=\"w3-button w3-display-bottommiddle w3-red\" style=\"width:100%\" title=\"Delete\" onclick=\"return goto()\">Delete</button>\r\n" + 
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
	    html += "</body>\n"
	    		+ "</html>\n";
		return html;
	}
}
