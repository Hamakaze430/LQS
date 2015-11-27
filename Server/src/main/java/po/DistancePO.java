package po;

import java.io.Serializable;

public class DistancePO implements Serializable{
	String city;
	String distance;
	
	public DistancePO(String c,String d){
		city = c;
		distance = d;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getDistance(){
		return distance;
	}

}
