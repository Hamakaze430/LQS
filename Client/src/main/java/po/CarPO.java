package po;

import java.io.Serializable;

public class CarPO implements Serializable{
	int id;
	String platenumber; 
	String timeinuse;
	
	public CarPO(int i,String pn,String tiu){
		id = i;
		platenumber = pn;
		timeinuse = tiu;
	}
	
	public int getID(){
		return id;
	}
	
	public String getPlateNumber(){
		return platenumber;
	}
	
	public String getTimeInUse(){
		return timeinuse;
	}

}
