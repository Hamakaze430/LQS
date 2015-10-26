package vo;

import java.util.Date;

public class CarVO {
	
	private String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String license;//车牌号
	private Date time;  //服役时间
	
	public CarVO(String id, String license, Date time){
		this.id = id;
		this.license = license;
		this.time = time;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getLicense(){
		return license;
	}
	
	public void setLicense(String license){
		this.license = license;
	}
	
	public Date getTime(){
		return time;
	}
	
	public void setTime(Date time){
		this.time = time;
	}
	
	
}
