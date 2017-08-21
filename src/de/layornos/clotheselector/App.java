package de.layornos.clotheselector;

import de.layornos.clotheselector.database.Credentials;
import de.layornos.clotheselector.database.DatabaseConnection;
import de.layornos.clotheselector.database.MySQLConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DatabaseConnection mysql = new MySQLConnection();
		Credentials c = new Credentials();
		c.name = "root";
		c.pw = "kenshin01";
		c.url = "jdbc:mysql://localhost:3306/clothes";
		mysql.setCredentials(c);
		mysql.connect();
//		mysql.executeUpdate(
//				"CREATE TABLE IF NOT EXISTS outfits (`name` VARCHAR(200) NOT NULL, path VARCHAR(200) NOT NULL, "
//				+ "`season` VARCHAR(30) NOT NULL, "
//				+ "`rain` BOOL NOT NULL, "
//				+ "`occasion` VARCHAR(200) NOT NULL, "
//				+ "UNIQUE `unique_name` (`name`(200))) "
//				+ "ENGINE = InnoDB;");
		// mysql.executeUpdate("DROP TABLE outfits;");

		OutfitHandler oh = new OutfitHandler(mysql);
		oh.addOutfit(createOutfitA());
		oh.addOutfit(createOutfitB());
//		oh.selectOutfits("SPRING", 1, "Geschäftlich");
//		oh.deleteOutfit("OutfitA");
//		for(Outfit o : oh.selectOutfits("SUMMER", 0, "Freizeit")) {
//			System.out.println(o);
//		}
    }

	private static Outfit createOutfitA() {
		Outfit o = new Outfit();
		o.name = "OutfitA";
		o.occasion = "Geschäftlich";
		o.rain = 1;
		o.season = Season.SPRING;
		return o;
	}
	
	private static Outfit createOutfitB() {
		Outfit o = new Outfit();
		o.name = "OutfitB";
		o.occasion = "Geschäftlich";
		o.rain = 0;
		o.season = Season.SPRING;
		return o;
	}
}
