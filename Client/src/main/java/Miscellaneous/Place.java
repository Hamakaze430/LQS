package Miscellaneous;

import java.io.Serializable;

public enum Place implements Serializable {
	北京市("010"),
	上海市("021"),
	广州市("020"),
	南京市("025");
	
	private String id;
	private Place(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public static Place value(String s) {
		Place[] es = Place.values();
		for (Place p : es)
			if (p.name().equals(s)) return p;
		return null;
		
	}
	
	public static Place fromId(String s) {
		Place[] es = Place.values();
		for (Place p : es)
			if (p.id.equals(s)) return p;
		return null;
		
	}
}
