package po;

import java.io.Serializable;
import po.*;

public class UserPO implements Serializable{
	public String name;
	public String id;
	public String password;
	
	public String position;
	public String authority;
	public HallPO hall;
	public CenterPO center;
	
	public UserPO (String name,String id,String password,String position,String authority,HallPO hall,CenterPO center){
		this.id=id;
		this.password=password;
		this.name=name;
		this.position=position;
		this.authority=authority;
		this.hall = hall;
		this.center=center;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setID(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	public void setPosition(String position) {
		// TODO Auto-generated method stub
		this.position=position;
	}

	public void steAuthority(String authority) {
		// TODO Auto-generated method stub
		this.authority=authority;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	
}
