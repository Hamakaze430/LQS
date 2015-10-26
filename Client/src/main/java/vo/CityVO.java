package vo;

import java.util.Date;

/**
 * Created by admin on 15/10/25.
 */
public class CityVO {
	
	private String beginplace;
	private String endplace;
	private double distance;
	private double price;
	
	public CityVO(String beginplace, String endplace, double distance,double price){
		this.beginplace=beginplace;
		this.endplace = endplace;
		this.distance = distance;
		this.price=price;
	}
	
	public String getbeginplace(){
		return beginplace;
	}
	
	public void setbeginplace(String beginplace){
		this.beginplace = beginplace;
	}
	
	public String getendplace(){
		return endplace;
	}
	
	public void setendplace(String endplace){
		this.endplace = endplace;
	}
	
	public double getdistance(){
		return distance;
	}
	
	public void setdistance(double distance){
		this.distance = distance;
	}
	
	public double getprice(){
		return price;
	}
	
	public void setprice(double price){
		this.price = price;
	}
	
	
	
}
