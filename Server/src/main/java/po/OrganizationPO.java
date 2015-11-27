package po;

import java.io.Serializable;

public class OrganizationPO implements Serializable{
	String job;
	String personalinfo;
	
	public OrganizationPO(String j,String pi){
		job = j;
		personalinfo = pi;
		
	}
	
	public String getJob(){
		return job;
	}
	
	public String getPersonalInfo(){
		return personalinfo;
	}
	
}
