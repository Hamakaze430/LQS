package po;

import java.io.Serializable;

public class DriverPO implements Serializable{
	int id;
	String name;
	char sex;
	String birthdate;
	String idnumber;
	String phonenumber;
	String license;

	public DriverPO(int i,String n,char c,String bd,String in,String pn,String l){
		id = i;
		name = n;
		birthdate = bd;
		idnumber = in;
		phonenumber = pn;
		license = l;
		}
	
	public int getID(){
		return id;
	}
	
	public char getSex(){
		return sex;
	}
	
	public String getBirthDate(){
		return birthdate;
	}
	
	public String getIDNumber(){
		return idnumber;
	}
	
	public String getPhoneNumber(){
		return phonenumber;
	}
	
	public String getLicense(){
		return license;
	}
	
}
