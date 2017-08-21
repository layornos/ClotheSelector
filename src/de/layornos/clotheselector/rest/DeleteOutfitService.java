package de.layornos.clotheselector.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/deleteoutfitservice")
public class DeleteOutfitService {
	
	@Path("{outfit}")
	@GET
	@Produces("text/plain")
	public String deleteOutfit(@PathParam("outfit") String outfitName) {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		boolean response = oh.deleteOutfit(outfitName);
		
		String result = "Output: " + response;
		return result;
	}
}
