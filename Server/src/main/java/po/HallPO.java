package po;

import java.io.Serializable;

public class HallPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String location;
	private String id;
	public HallPO(String name, String id, String location){
		this.name = name;
		this.location = location;
		this.id = id;
	}
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getID(){
		return id;
	}
	
	public boolean compareTo(HallPO b){
	    return name.equals(b.getName())|id.equals(b.getID())|location.equals(b.getLocation());		 
	}
	
}
