package po;

import java.io.Serializable;

public class DriverPO implements Serializable{
	String id;
	String name;
	String sex;
	String birthdate;
	String phonenumber;
	String license;

	public DriverPO(String i,String n,String c,String bd,String pn,String l){
		id = i;
		name = n;
		sex=c;
		birthdate = bd;
		phonenumber = pn;
		license = l;
		}
	
	public String getID(){
		return id;
	}
	
	public String getSex(){
		return sex;
	}
	
	public String getBirthDate(){
		return birthdate;
	}
	
//	public String getIDNumber(){
//		return idnumber;
//	}
	
	public String getPhoneNumber(){
		return phonenumber;
	}
	
	public String getLicense(){
		return license;
	}
	
}
