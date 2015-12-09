package vo;

public class StationVO {
	String id;
	String name;

	public StationVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
