package vo;

public class UserVO {
	private String name;
	private String id;
	private String password;
	
	private String position;
	private String authority;
	private HallVO hall;
	
	public UserVO (String name,String id,String password,String position,String authority,HallVO hall){
		this.id=id;
		this.password=password;
		this.name=name;
		this.position=position;
		this.authority=authority;
		this.hall = hall;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getID(){
		return id;
	}
	
	public void setID(String id){
		this.id=id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String position){
		this.position=position;
	}
	
	public String getAuthority(){
		return authority;
	}
	
	public void setAuthority(String authority){
		this.authority=authority;
	}
	
	public HallVO getHall(){
		return hall;
	}
	
	public String getHallId(){
		return hall.getId();
	}
	
}
