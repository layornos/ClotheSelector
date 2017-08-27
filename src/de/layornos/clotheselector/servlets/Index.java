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
				"<title>Clothe Selector</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<div class=\"w3-container\"><h1>Clothe Selector</h1></div>" +	
				"<div class=\"w3-container\"><h2>Search Outfit</h2></div>\n" +
				"<form action=\"outfits/search/outfit\" method=\"post\"\n" + 
				"		enctype=\"multipart/form-data\">\n" + 
				"		Season<br> <select name=\"season\">\n" + 
				"			<option value=\"SPRING\">Spring</option>\n" + 
				"			<option value=\"SUMMER\">Summer</option>\n" + 
				"			<option value=\"AUTUMN\">Autumn</option>\n" + 
				"			<option value=\"WINTER\">Winter</option>\n" + 
				"		</select><br> \n" + 
				"		Occasion<br> <input type=\"text\" id=\"occasion\" name=\"occasion\"><br>\n" + 
				"		Rain<br> <input type=\"checkbox\" id=\"rain\" name=\"rain\"><br>\n" + 
				"		<input type=\"submit\" value=\"Search Outfit\" />\n" + 
				"	</form>\n" +
				"<button class=\"w3-button w3-display-right w3-blac\" title=\"Add Outfit\" onclick=\"return gotoAddOutfit()\">Add Outfit</button><br><br>\n" +
				"<button class=\"w3-button w3-display-right w3-blac\" title=\"Show all Outfits\" onclick=\"return gotoAllOutfits()\">Show all Outfits</button>\n" +
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
