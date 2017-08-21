package de.layornos.clotheselector.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import de.layornos.clotheselector.Outfit;
import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/getalloutfitsservice")
public class GetAllOutfitsService {
	
	@GET
	@Produces("application/json")
	public Response allOutfits() throws SQLException {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		List<Outfit> outfits = oh.getAllOutfits();
		JSONObject response = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(Outfit outfit : outfits) {
			JSONObject jsonOutfit = new JSONObject();	
			jsonOutfit.put("name", outfit.name);
			jsonOutfit.put("season", outfit.season);
			jsonOutfit.put("rain", outfit.rain);
			jsonOutfit.put("occasion", outfit.occasion);
			jsonOutfit.put("url", outfit.url);
			array.put(jsonOutfit);
		}
		
		response.put("outfits", array);
		
		String result = "@Produces(\"application/json\") Output: " + response;
		return Response.status(200).entity(result).build();
	}
}
