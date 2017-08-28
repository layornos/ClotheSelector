package de.layornos.clotheselector.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String html = "<html>\n" + 
				"<head>\n" + 
				"<script src=\"/ClotheSelector/jquery.js\"></script>\n" +
	    		"<script src=\"/ClotheSelector/trashButton.js\"></script>\n" +
				"<meta charset=\"UTF-8\">\n" +
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"all.css\">\n" + 
				"<title>Clothe Selector</title>\n"+
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
				"<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
				"<link rel=\"stylesheet\" href=\"/ClotheSelector/all.css\">\n" +
				"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n" + 
				"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">"+ 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"w3-container w3-text-teal\"><h1>Clothe Selector</h1></div>" +	
				"<div class=\"w3-container\"><h2>Search Outfit</h2></div>\n" +
				"<form class=\"w3-panel\" action=\"outfits/search/outfit\" method=\"post\"\n" + 
				"		enctype=\"multipart/form-data\">\n" + 
				"		Season<br> <select class=\"w3-select\" name=\"season\">\n" + 
				"			<option value=\"SPRING\">Spring</option>\n" + 
				"			<option value=\"SUMMER\">Summer</option>\n" + 
				"			<option value=\"AUTUMN\">Autumn</option>\n" + 
				"			<option value=\"WINTER\">Winter</option>\n" + 
				"		</select><br><br> \n" + 
				"		Occasion<br> <input class=\"w3-input\" type=\"text\" id=\"occasion\" name=\"occasion\"><br><br>\n" + 
				"		<input class=\"w3-check\" type=\"checkbox\" id=\"rain\" name=\"rain\"> Rain<br><br>\n" + 
				"</form>\n" +
				"<div class=\"w3-container\" style=\"width:100%\">\n"+
				"	\t<button class=\"w3-button w3-display-bottomleft w3-teal\" onclick=\"document.forms[0].submit();\">Search Outfit</button>\n"+
				"	\t<button class=\"w3-button w3-display-bottommiddle w3-teal\" title=\"Add Outfit\" onclick=\"return gotoAddOutfit()\">Add Outfit</button>\n" +
				"	\t<button class=\"w3-button w3-display-bottomright w3-teal\" title=\"Show all Outfits\" onclick=\"return gotoAllOutfits()\">Show all Outfits</button>\n" +
				"</div>\n"+
				"</body>\n" + 
				"</html>";
		response.setContentType("text/html");
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
