package vo;

public class LoginVO {
	private String id;
	private String password;
	
	public LoginVO(String id,String password){
		this.id=id;
		this.password=password;		
	}
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
}
