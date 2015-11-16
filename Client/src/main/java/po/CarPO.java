package po;

import java.io.Serializable;

public class CarPO implements Serializable{
	String id;
	String platenumber; 
	String timeinuse;
	
	public CarPO(String i,String pn,String tiu){
		id = i;
		platenumber = pn;
		timeinuse = tiu;
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

}
