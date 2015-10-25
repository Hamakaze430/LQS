package po;

import java.io.Serializable;

public class PricePO implements Serializable{
	String specie;
	String price;
	
	public PricePO(String s,String p){
		specie = s;
		price = p;
	}
	
	public String getSpecie(){
		return specie;
	}
	
	public String getPrice(){
		return price;
	}

}
