package vo;

import java.util.Vector;

import Miscellaneous.Place;

public class HallVO extends Vector<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallVO(String name, String id, String location){
		this.add(name);
		this.add(id);
		this.add(location);
		
	}
	public String getName(){
		return get(0);
	}

	public String getLocation(){
		return get(2);
	}

	public String getID(){
		return get(1);
	}

	public String getType(){
		int len = getID().length();
		if (len == 3) return "公司";
		if (len == 4) return "中转中心";
		return "营业厅";
	}
	
	public Place getPlace(){
		String id = getID();
		if (id.length() != 3) return Place.fromId(id.substring(0,3));
		return null;
	}
}
