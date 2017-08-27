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
				"<meta charset=\"UTF-8\">\n" + 
				"<title>ClotheSelector - Create Outfit</title>\n" + 
				"<script type=\"text/javascript\" src=\"jquery.js\"></script>\n" + 
				"<script type=\"text/javascript\" src=\"outfit_control.js\"></script>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<div class=\"w3-container\"><h1>Clothe Selector</h1></div>" +	
				"	<div class=\"w3-container\"><h2>Add Outfit</h2></div>\n" + 
				"	<form action=\"outfits/restwb/upload\" method=\"post\"\n" + 
				"		enctype=\"multipart/form-data\">\n" +
				"		<br> Outfit<br> <input type=\"text\" id=\"outfit\" name=\"outfit\"><br>\n" + 
				"		Season<br> <select name=\"season\">\n" + 
				"			<option value=\"SPRING\">Spring</option>\n" + 
				"			<option value=\"SUMMER\">Summer</option>\n" + 
				"			<option value=\"AUTUMN\">Autumn</option>\n" + 
				"			<option value=\"WINTER\">Winter</option>\n" + 
				"		</select><br> \n" + 
				"		Occasion<br> <input type=\"text\" id=\"occasion\" name=\"occasion\"><br>\n" + 
				"		Rain<br> <input type=\"checkbox\" id=\"rain\" name=\"rain\"><br>\n" + 
				"		Image<br> <input type=\"file\" id=\"filename\" name=\"filename\"\n" + 
				"			accept=\"image/x-png,image/gif,image/jpeg\"><br> <br>\n" + 
				"		<input type=\"submit\" value=\"Upload\" />\n" + 
				"	</form>\n" + 
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
