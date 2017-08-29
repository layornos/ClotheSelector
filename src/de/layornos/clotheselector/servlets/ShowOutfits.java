package de.layornos.clotheselector.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.layornos.clotheselector.pagebuilder.SlideshowBuilder;

/**
 * Servlet implementation class ShowOutfits
 */
@WebServlet("/showOutfits")
public class ShowOutfits extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowOutfits() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> imagePaths = getAllImageInIMG();
		response.setContentType( "text/html" );
		String html = SlideshowBuilder.createSlideshowHTML(imagePaths);
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<String> getAllImageInIMG() {
		List<String> imagePaths = new ArrayList<String>();
		Consumer<Path> pathFiller = (Path p) -> imagePaths.add(p.toString()); 
		File f = new File(getServletContext().getRealPath("/img"));
		if(!f.exists())
			f.mkdir();
		try (Stream<Path> paths = Files.walk(Paths.get(getServletContext().getRealPath("/img")))) {
		    paths
		        .filter(Files::isRegularFile)
		        .forEach(pathFiller);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		for(String s :imagePaths)
			System.out.println(s);
		
		List<String> shortenImagePaths = new ArrayList<String>();
		for(String s : imagePaths) {
			if(s.contains("img")) {
				String path = s.substring(s.indexOf("img"));
				shortenImagePaths.add(path);
			}
		}
		return shortenImagePaths;
	}

}
