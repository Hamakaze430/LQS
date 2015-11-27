package po;

public class LoginPO {
	private String id;
	private String password;
	
	public LoginPO(String id,String password){
		this.id=id;
		this.password=password;
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
	
	
}
