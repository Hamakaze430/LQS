package po;

import java.io.Serializable;

public class CommodityPO implements Serializable {
	private String id;
	private String dateofin;
	private String specie;
	private String location;
	private String price;

	public CommodityPO(String i, String doi, String s, String l, String p) {
		id = i;
		dateofin = doi;
		specie = s;
		location = l;
		price = p;
	}

	public String getID() {
		return id;
	}

	public String getDateOfIn() {
		return dateofin;
	}

	public String getSpecie() {
		return specie;
	}

	public String getLocation() {
		return location;
	}

	public String getPrice() {
		return price;
	}

}