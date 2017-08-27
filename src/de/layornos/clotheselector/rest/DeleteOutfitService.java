package de.layornos.clotheselector.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/deleteoutfitservice")
public class DeleteOutfitService {
	@Context ServletContext servletContext;
	
	@Path("{id}")
	@GET
	@Produces("text/plain")
	public String deleteOutfit(@PathParam("id") String id) {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		boolean response = oh.deleteOutfit(id, servletContext);
		
		String result = "Output: " + response;
		return result;
	}
}
