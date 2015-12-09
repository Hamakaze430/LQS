package vo;

import java.util.Date;

import po.DriverPO;

public class DriverVO {
	
	private String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String name;//姓名
	private String birth;  //出生日期
	private String identity; //身份证号
	private String mobile; //手机
	private String gender; //男/女
	private String time; //行驶证期限
	
	public DriverVO(String id, String name, String birth, String identity, String mobile, String gender, String time){
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.identity = identity;
		this.mobile = mobile;
		this.gender = gender;
		this.time = time;
	}
	
	public DriverVO(DriverPO driverPO){
		id=driverPO.getId();
		name=driverPO.getName();
		birth=driverPO.getBirth();
		identity=driverPO.getIdentity();
		mobile=driverPO.getMobile();
		gender=driverPO.getGender();
		time=driverPO.getTime();
	}
	
	public String getId(){
		return id;
	}	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}	
	public void setName(String name){
		this.name = name;
	}
	
	public String getBirth(){
		return birth;
	}
	public void setBirth(String birth){
		this.birth = birth;
	}
	
	public String getIdentity(){
		return identity;
	}	
	public void setIdentity(String identity){
		this.identity = identity;
	}
	
	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getGender(){
		return gender;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getTime(){
		return time;
	}
	public void setTime(String time){
		this.time = time;
	}
	
}