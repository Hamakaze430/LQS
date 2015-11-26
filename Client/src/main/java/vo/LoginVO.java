package vo;

public class LoginVO {
	public String id;
	public String password;
	
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

	public void setID(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}
}
