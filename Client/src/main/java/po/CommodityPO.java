package po;

import java.io.Serializable;

public class CommodityPO implements Serializable{
	int id;
	String dateofin;
	String specie;
	String location;
	String price;
	
	public CommodityPO(int i,String doi,String s,String l,String p){
		id = i;
		dateofin = doi;
		specie = s;
		location = l;
		price = p;
	}
	
	public int getID(){
		return id;
	}
	
	public String getDateOfIn(){
		return dateofin;
	}
	
	public String getSpecie(){
		return specie;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getPrice(){
		return price;
	}
	
}
