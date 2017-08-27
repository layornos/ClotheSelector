package de.layornos.clotheselector;

import java.io.File;
import java.io.FileFilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import de.layornos.clotheselector.database.DatabaseConnection;

public class OutfitHandler {

	private DatabaseConnection db;

	public OutfitHandler(DatabaseConnection db) {
		this.db = db;
		db.connect();
	}

	public boolean addOutfit(Outfit o) {
		String query = "INSERT INTO `outfits` (`id`, `name`, `path`, `season`, `rain`, `occasion`) VALUES ('"+ o.id +"', '"+ o.name +"', '"+ o.id+"_"+ o.name + "_" + o.season + "_" + o.rain + "_" + o.occasion +"', '"+ o.season +"', '"+ o.rain +"', '"+ o.occasion +"');";
		try {
			db.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteOutfit(String id, ServletContext servletContext) {
		String query = "DELETE FROM `outfits` WHERE `outfits`.`id` = \'"+ id +"\'";
		try {
			db.executeUpdate(query);
			String path = servletContext.getRealPath("/img/");
			
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();

			for(File f : listOfFiles) {
				if(f.getName().contains(id)) {
					f.delete();
				}
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
	}

	public List<Outfit> getAllOutfits() throws SQLException {
		List<Outfit> outfits = new ArrayList<Outfit>();
		String query = "SELECT * FROM outfits;";
		ResultSet rs = db.executeQuery(query);
		Outfit o = new Outfit();
		try {
			while(rs.next()) {
				o.id = rs.getString(1);
				o.name = rs.getString(2);
				o.url = rs.getString(3);
				if(rs.getString(4).equals("SPRING"))
					o.season = Season.SPRING;
				else if (rs.getString(4).equals("SUMMER"))
					o.season = Season.SUMMER;
				else if (rs.getString(4).equals("AUTUMN"))
					o.season = Season.AUTUMN;
				else
					o.season = Season.WINTER;
				o.rain = rs.getInt(5);
				o.occasion = rs.getString(6);
				outfits.add(o);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return outfits;
	}

	public List<Outfit> selectOutfits(String season, int rain, String occasion) throws SQLException {
		List<Outfit> outfits = new ArrayList<Outfit>();
		String query = "SELECT * FROM `outfits` WHERE `outfits`.`season`=\'"+ season +"\'"
				+ " AND `outfits`.`rain`=\'" + rain + "\' AND `outfits`.`occasion`=\'" + occasion + "\'";
		ResultSet rs = db.executeQuery(query);
		
		try {
			while(rs.next()) {
				Outfit o = new Outfit();
				o.id = rs.getString(1);
				o.name = rs.getString(2);
				o.url = rs.getString(3);
				if(rs.getString(4).equals("SPRING"))
					o.season = Season.SPRING;
				else if(rs.getString(4).equals("SUMMER"))
					o.season = Season.SUMMER;
				else if(rs.getString(4).equals("AUTUMN"))
					o.season = Season.AUTUMN;
				else
					o.season = Season.WINTER;
				o.rain = rs.getInt(5);
				o.occasion = rs.getString(6);
				outfits.add(o);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return outfits;
	}
}
