package vo;

public class UserBaseVO {
	public final String name;
	public final HallVO hall;
	public UserBaseVO(String name, HallVO hall){
		this.name = name;
		this.hall = hall;
	}
}
