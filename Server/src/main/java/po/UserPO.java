package po;

import java.io.Serializable;


public class UserPO implements Serializable{
	
	private String id;
	private String password;
	private String authority;
	
	private String name;
	private String sex;
	private String job;
	private String hallId;
	
	public UserPO (String id, String password,String authority,String name,String sex, String job, String hallId){
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.authority = authority;
		this.job = job;
		this.hallId=hallId;
	}
	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getHallId() {
		// TODO Auto-generated method stub
		return hallId;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getSex(){
		return sex;
	}
	
	public String getJob(){
		return job;
	}
}
