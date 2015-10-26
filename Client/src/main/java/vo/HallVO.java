package vo;

public class HallVO {
	String name;
	String location;
	String id;
	public HallVO(String name, String location, String id){
		this.name = name;
		this.location = location;
		this.id = id;
	}
	public String getId(){
		return id;
	}
}
