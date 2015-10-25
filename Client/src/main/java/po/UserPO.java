package po;

import java.io.Serializable;

public class UserPO implements Serializable{
	int id;
	String password;
	String personalinfo;
	String competence;
	
	public UserPO(int i,String p,String pl,String c){
		id = i;
		password = p;
		personalinfo = pl;
		competence = c;
	}
	
	public int getID(){
		return id;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getPersonalInfo(){
		return personalinfo;
	}
	
	public String getCompetence(){
		return competence;
	}
	
}
