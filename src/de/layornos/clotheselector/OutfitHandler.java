package de.layornos.clotheselector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.layornos.clotheselector.database.DatabaseConnection;

public class OutfitHandler {

	private DatabaseConnection db;

	public OutfitHandler(DatabaseConnection db) {
		this.db = db;
		db.connect();
	}

	public boolean addOutfit(Outfit o) {
		String query = "INSERT INTO `outfits` (`name`, `path`, `season`, `rain`, `occasion`) VALUES ('"+ o.name +"', '"+ o.name + "_" + o.season + "_" + o.rain + "_" + o.occasion +"', '"+ o.season +"', '"+ o.rain +"', '"+ o.occasion +"');";
		try {
			db.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteOutfit(String name) {
		String query = "DELETE FROM `outfits` WHERE `outfits`.`name` = \'"+ name +"\'";
		try {
			db.executeUpdate(query);
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
				o.name = rs.getString(1);
				o.url = rs.getString(2);
				if(rs.getString(3).equals("SPRING"));
					o.season = Season.SPRING;
				o.rain = rs.getInt(4);
				o.occasion = rs.getString(5);
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
		Outfit o = new Outfit();
		try {
			while(rs.next()) {
				o.name = rs.getString(1);
				o.url = rs.getString(2);
				if(rs.getString(3).equals("SPRING"))
					o.season = Season.SPRING;
				else if(rs.getString(3).equals("SUMMER"))
					o.season = Season.SUMMER;
				else if(rs.getString(3).equals("AUTUMN"))
					o.season = Season.AUTUMN;
				else
					o.season = Season.WINTER;
				o.rain = rs.getInt(4);
				o.occasion = rs.getString(5);
				outfits.add(o);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return outfits;
	}
}
