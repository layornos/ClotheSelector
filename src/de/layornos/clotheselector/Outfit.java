package de.layornos.clotheselector;

public class Outfit {
	public String name;
	public Season season;
	public int rain;
	public String occasion;
	public String url;
	public String id;
	
	@Override
	public String toString() {
		return "Name: "+ name + ", Season: "+ season +", Rain: "+ rain+", Occasion: " + occasion + ", URL: " + url +", ID: " + id; 
	}
	
	public String createFileName() {
		String rainName;
		if(rain == 0)
			rainName = "off";
		else
			rainName = "on";
		return id + "_" + name + "_" + season +  "_" + occasion + "_" + rainName;
	}
}
