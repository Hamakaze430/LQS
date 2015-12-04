package vo;

public class UserBaseVO {
	public final String name;
	public final HallVO hall;
	public final int sex;
	public UserBaseVO(String name, int sex,HallVO hall){
		this.name = name;
		this.sex=sex;
		this.hall = hall;
	}
}
