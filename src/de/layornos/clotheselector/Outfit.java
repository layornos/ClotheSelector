package de.layornos.clotheselector;

public class Outfit {
	public String name;
	public Season season;
	public int rain;
	public String occasion;
	public String url;
	
	@Override
	public String toString() {
		return "Name: "+ name + ", Season: "+ season +", Rain: "+ rain+", Occasion: " + occasion + ", URL: " + url; 
	}
}
