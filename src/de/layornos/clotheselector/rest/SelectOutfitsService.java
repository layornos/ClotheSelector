package de.layornos.clotheselector.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import de.layornos.clotheselector.Outfit;
import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/selectoutfitsservice")
public class SelectOutfitsService {
	
	@Path("{season}/{rain}/{occasion}")
	@GET
	@Produces("application/json")
	public Response selectOutfits(@PathParam("season") String season,
								@PathParam("rain") int rain,
								@PathParam("occasion") String occasion) throws SQLException {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		List<Outfit> outfits = oh.selectOutfits(season, rain, occasion);
		JSONObject response = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(Outfit outfit : outfits) {
			JSONObject jsonOutfit = new JSONObject();	
			jsonOutfit.put("id", outfit.id);
			jsonOutfit.put("name", outfit.name);
			jsonOutfit.put("season", outfit.season);
			jsonOutfit.put("rain", outfit.rain);
			jsonOutfit.put("occasion", outfit.occasion);
			jsonOutfit.put("url", outfit.url);
			array.put(jsonOutfit);
		}
		
		response.put("outfits", array);
		
		String result = "" + response;
		return Response.status(200).entity(result).build();
	}
}
