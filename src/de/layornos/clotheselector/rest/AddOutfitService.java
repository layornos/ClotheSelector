package de.layornos.clotheselector.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.layornos.clotheselector.Outfit;
import de.layornos.clotheselector.OutfitHandler;
import de.layornos.clotheselector.Season;
import de.layornos.clotheselector.database.MySQLConnection;

@Path("/addoutfitservice")
public class AddOutfitService {
	
	@Path("{outfit}/{season}/{rain}/{occasion}")
	@GET
	@Produces("text/plain")
	public String addOutfit(@PathParam("outfit") String outfitName,
			@PathParam("season") String season,
			@PathParam("rain") int rain,
			@PathParam("occasion") String occasion) {
		OutfitHandler oh = new OutfitHandler(new MySQLConnection());
		boolean response = oh.addOutfit(createOutfit(outfitName, season, rain, occasion));
			
		String result = "Output: " + response;
		return result;
	}
	
	public Outfit createOutfit(String outfitName, String season, int rain, String occasion) {
		Outfit o = new Outfit();
		o.name = outfitName;
		if(season.equals("SPRING"))
			o.season = Season.SPRING;
		else if (season.equals("SUMMER"))
			o.season = Season.SUMMER;
		else if (season.equals("AUTUMN"))
			o.season = Season.AUTUMN;
		else
			o.season = Season.WINTER;
		o.rain = rain;
		o.occasion = occasion;
		return o;
	}
}
