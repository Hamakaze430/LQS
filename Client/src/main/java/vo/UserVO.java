package vo;

public class UserVO {
	public final String name;
	public final String id;
	public final String password;
	
	public final String position;
	public final String authority;
	public final HallVO hall;
	
	public UserVO (String name,String id,String password,String position,String authority,HallVO hall){
		this.id=id;
		this.password=password;
		this.name=name;
		this.position=position;
		this.authority=authority;
		this.hall = hall;
	}

	
}
