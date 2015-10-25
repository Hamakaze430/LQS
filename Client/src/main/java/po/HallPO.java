package po;

import java.io.Serializable;

public class HallPO implements Serializable{
	int id;
	String city;
	
	public HallPO(int i,String c){
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
