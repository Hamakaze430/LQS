package po;

import vo.CenterVO;

public class CenterPO {
	private String name;
	private String location;
	private String id;
	
	public CenterPO(CenterVO vo){
		name=vo.getName();
		location=vo.getLocation();
		id=vo.getID();
	}
	
	public CenterPO(String name, String location, String id){
		this.name = name;
		this.location = location;
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getLocation(){
		return location;
	}
	public void setLocation(String location){
		this.location=location;
	}
	public String getID(){
		return id;
	}
	public void setID(String name){
		this.id=id;
	}
}
