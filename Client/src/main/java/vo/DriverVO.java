package vo;

import java.util.Date;
import java.util.Vector;

import po.DriverPO;

public class DriverVO extends Vector<String> {
	
	private String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String name;//姓名
	private String birth;  //出生日期
	private String identity; //身份证号
	private String mobile; //手机
	private String gender; //男/女
	private String time; //行驶证期限
	
	public DriverVO(String id, String name,String gender, String birth, String identity, String mobile,  String time){
		this.add(id);
		this.add(name);
		this.add(gender);
		this.add(birth);
		this.add(identity);
		this.add(mobile);	
		this.add(time);
	}
	
	public DriverVO(DriverPO po){
		this.add(po.getId());
		this.add(po.getName());
		this.add(po.getGender());
		this.add(po.getBirth());
		this.add(po.getIdentity());
		this.add(po.getMobile());	
		this.add(po.getTime());
	}
	
	public String getId(){
		return get(0);
	}	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return get(1);
	}	
	public void setName(String name){
		this.name = name;
	}
	
	public String getBirth(){
		return get(3);
	}
	public void setBirth(String birth){
		this.birth = birth;
	}
	
	public String getIdentity(){
		return get(4);
	}	
	public void setIdentity(String identity){
		this.identity = identity;
	}
	
	public String getMobile(){
		return get(5);
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getGender(){
		return get(2);
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getTime(){
		return get(6);
	}
	public void setTime(String time){
		this.time = time;
	}
	
}