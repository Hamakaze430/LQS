package vo;

import java.util.Vector;

import po.UserPO;

public class UserVO extends Vector<String> {
	
	
	private String id;
	private String password;
	private String authority;
	
	private String name;
	private String sex;
	private String job;
	private String hallId;
	
	public UserVO(UserPO po){
		id=po.getID();
		password=po.getPassword();
		authority=po.getAuthority();
		name=po.getName();
		sex=po.getSex();
		job=po.getJob();
		hallId=po.getHallId();
	}
	
	public UserVO (String id,String password,String authority,String name,String sex,String job,String hall){
		this.add(id);
		this.add(password);
		this.add(authority);
		this.add(name);
		this.add(sex);
		this.add(job);
		this.add(hall);
	}

	public void setPassword(String s){
		this.set(1, s);
	}
	
	public String getID() {
		// TODO Auto-generated method stub
		return get(0);
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return get(1);
	}
	
	public String getSex(){
		return get(4);
	}

	public String getJob() {
		// TODO Auto-generated method stub
		return get(5);
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return get(2);
	}
	
	public String getHall(){
		return get(6);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return get(3);
	}
}
