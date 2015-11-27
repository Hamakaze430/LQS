package po;

import java.io.Serializable;

public class TransitCenterPO implements Serializable{
	int id;
	String city;
	
	public TransitCenterPO(int i,String c){
		id = i;
		city = c;
	}
	
	public int getID(){
		return id;
	}
	
	public String getCity(){
		return city;
	}

}
