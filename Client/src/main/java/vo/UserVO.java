package vo;

public class UserVO {
	private String name;
	private String id;
	private String password;
	
	private String position;
	private String authority;
	
	public UserVO (String name,String id,String password,String position,String authority){
		this.id=id;
		this.password=password;
		this.name=name;
		this.position=position;
		this.authority=authority;
	}
	private String getName(){
		return name;
	}
	
	private void setName(String name){
		this.name=name;
	}
	
	private String getID(){
		return id;
	}
	
	private void setID(String id){
		this.id=id;
	}
	
	private String getPassword(){
		return password;
	}
	
	private void setPassword(String password){
		this.password=password;
	}
	
	private String getPosition(){
		return position;
	}
	
	private void setPosition(String position){
		this.position=position;
	}
	
	private String getAuthority(){
		return authority;
	}
	
	private void setAuthority(String authority){
		this.authority=authority;
	}
	
	
	
	
}
