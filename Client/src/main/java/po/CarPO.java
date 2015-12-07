package po;

import java.io.Serializable;
import java.util.Date;

public class CarPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id; //城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字
	private String license;//车牌号
	private Date time;  //服役时间
	
	public CarPO(String id, String license, Date time){
		this.id = id;
		this.license = license;
		this.time = time;
	}
	
	public String getID(){
		return id;
	}
	
	public String getLicense(){
		return license;
	}
	
	public Date getTime(){
		return time;
	}

}
