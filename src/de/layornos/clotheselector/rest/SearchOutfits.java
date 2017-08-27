package de.layornos.clotheselector.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import de.layornos.clotheselector.Outfit;
import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.database.MySQLConnection;
import de.layornos.clotheselector.pagebuilder.SlideshowBuilder;

@Path("/search")
public class SearchOutfits {

	@POST
	@Path("/outfit")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response searchOutfit(@FormDataParam("rain") String rain,
								@FormDataParam("season") String season,
								@FormDataParam("occasion") String occasion) {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		if(rain == null)
			rain = "0";
		else
			rain = "1";
		
		List<Outfit> outfits = null;
		try {
			outfits= oh.selectOutfits(season, Integer.parseInt(rain), occasion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<String> imagePaths = new ArrayList<String>();
		for(Outfit o : outfits)
			imagePaths.add("../../img/"+o.createFileName()+".jpg");
		String html = SlideshowBuilder.createSlideshowHTML(imagePaths);
		
		
		return Response.status(200).entity(html).build();
	}
}
