package vo;

import java.util.Vector;

public class HallVO extends Vector<String> {
//	public String name;
//	public String location;
//	public String id;
	public HallVO(String name, String id, String location){
//		this.name = name;
//		this.location = location;
//		this.id = id;
		this.add(name);
		this.add(id);
		this.add(location);
		
	}
	public String getName(){
		return get(0);
	}
//	public void setName(String name){
//		this.name=name;
//	}
	public String getLocation(){
		return get(2);
	}
//	public void setLocation(String location){
//		this.location=location;
//	}
	public String getID(){
		return get(1);
	}
//	public void setID(String name){
//		this.id=id;
//	}
}
