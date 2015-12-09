package vo;

import java.util.Date;

import po.CarPO;

public class CarVO {
	
	private String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String license;//车牌号
	private String time;  //服役时间
	
	public CarVO(String id, String license, String time){
		this.id = id;
		this.license = license;
		this.time = time;
	}
	
	public CarVO(CarPO po){
		id=po.getID();
		license=po.getLicense();
		time=po.getTime();
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
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	
}
