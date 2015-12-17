package vo;

import java.util.Date;
import java.util.Vector;

import po.CarPO;

public class CarVO extends Vector<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CarVO(String id, String license, String time){
		this.add(id);
		this.add(license);
		this.add(time);
	}
	
	public CarVO(CarPO next) {
		// TODO Auto-generated constructor stub
	}

	public String getId(){
		return get(0);
	}
	public String getLicense(){
		return get(1);
	}	
	public String getTime(){
		return get(2);
	}

}
