package de.layornos.clotheselector.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import de.layornos.clotheselector.Outfit;
import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.Season;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/restwb")
public class FileResource {
	private Random randomGenerator = new Random();
	private OutfitHandler oh = new OutfitHandler(new MySQLConnection());
	private int id;
	@Context ServletContext servletContext;

	@POST
	@Path("/upload")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadFile(@FormDataParam("filename") InputStream is,
			@FormDataParam("filename") FormDataContentDisposition formData, @FormDataParam("outfit") String outfit,
			@FormDataParam("season") String season, @FormDataParam("occasion") String occasion,
			@FormDataParam("rain") String rain) {
		String fileLocation = createFilePath(formData, outfit, season, occasion, rain);
		try {
			saveFile(is, fileLocation);
			saveOutfitInDatabase(outfit, season, occasion, rain, fileLocation, id);
			String result = "Successfully File Uploaded on the path " + fileLocation;
			return Response.status(Status.OK).entity(result).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	private void saveOutfitInDatabase(String name, String season, String occasion, String rain, String path, int id) {
		oh.addOutfit(createOutfit(name, season, occasion, rain, path, id));
	}

	private Outfit createOutfit(String name, String season, String occasion, String rain, String path, int id) {
		Outfit o = new Outfit();
		o.name = name;
		if (season.equals("SPRING"))
			o.season = Season.SPRING;
		else if (season.equals("SUMMER"))
			o.season = Season.SUMMER;
		else if (season.equals("AUTUMN"))
			o.season = Season.AUTUMN;
		else
			o.season = Season.WINTER;
		o.occasion = occasion;
		o.url = path;
		o.id = Integer.toString(id);
		return o;
	}

	private String createFilePath(FormDataContentDisposition formData, String outfit, String season, String occasion,
			String rain) {
		if (rain == null)
			rain = "off";
		id = randomGenerator.nextInt(999999999);
		String fileName = id +"_"+outfit + "_" + season + "_" + occasion + "_" + rain;

		String fileLocation = servletContext.getRealPath("/img/")  + fileName
				+ formData.getFileName().substring(formData.getFileName().indexOf('.'));
		System.out.println(fileLocation);
		return fileLocation;
	}

	private void saveFile(InputStream is, String fileLocation) throws IOException {
		OutputStream os = new FileOutputStream(new File(fileLocation));
		byte[] buffer = new byte[256];
		int bytes = 0;
		while ((bytes = is.read(buffer)) != -1) {
			os.write(buffer, 0, bytes);
		}
		os.close();
	}
}