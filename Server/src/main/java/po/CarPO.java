package po;

import java.io.Serializable;

public class CarPO implements Serializable{
	String id;
	String platenumber; 
	String timeinuse;
	String location;
	
	public CarPO(String i,String pn,String tiu, String location){
		id = i;
		platenumber = pn;
		timeinuse = tiu;
		this.location=location;
	}
	
	public String getID(){
		return id;
	}
	
	public String getPlateNumber(){
		return platenumber;
	}
	
	public String getTimeInUse(){
		return timeinuse;
	}
	
	public String getLocation(){
		return this.location;
	}

}
