package de.layornos.clotheselector.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOutfit
 */
@WebServlet("/addOutfit")
public class AddOutfit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOutfit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<head>\n" + 
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
				"<div class=\"w3-container\"><h2>Add Outfit</h2></div>\n" +
				"	<form class=\"w3-panel\" action=\"outfits/restwb/upload\" method=\"post\"\n" + 
				"		enctype=\"multipart/form-data\">\n" +
				"		<br> Outfit<br> <input type=\"text\" id=\"outfit\" name=\"outfit\"><br><br>\n" + 
				"		Season<br> <select class=\"w3-select\" name=\"season\">\n" + 
				"			<option value=\"SPRING\">Spring</option>\n" + 
				"			<option value=\"SUMMER\">Summer</option>\n" + 
				"			<option value=\"AUTUMN\">Autumn</option>\n" + 
				"			<option value=\"WINTER\">Winter</option>\n" + 
				"		</select><br><br> \n" + 
				"		Occasion<br> <input class=\"w3-input\" type=\"text\" id=\"occasion\" name=\"occasion\"><br><br>\n" + 
				"		<input class=\"w3-check\" type=\"checkbox\" id=\"rain\" name=\"rain\"> Rain<br><br>\n" + 
				"		Image<br> <input class=\"w3-input\" type=\"file\" id=\"filename\" name=\"filename\"\n" + 
				"			accept=\"image/x-png,image/gif,image/jpeg\"><br> <br>\n" + 
//				"		<input class=\"w3-button w3-teal\" style=\"width:100%\" type=\"submit\" value=\"Upload\" />\n" + 
				"	</form>\n" + 
				"<button class=\"w3-button w3-display-bottommiddle w3-teal\" style=\"width:100%\" title=\"Upload\" onclick=\"return uploadImage();\">Upload</button>\n"+
				"</body>\n" + 
				"</html>";
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
