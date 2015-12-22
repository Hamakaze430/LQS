package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalVO extends Vector<String> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ApprovalVO(String type,String number, String apartment, String status){
		this.add(type);
		this.add(number);
		this.add(apartment);
		this.add(status);
	}
	
	public String getType(){
		return get(0);
	}
	public String getNumber(){
		return get(1);
	}
	public String getApartment(){
		return get(2);
	}
	public String getStatus(){
		return get(3);
	}
}

