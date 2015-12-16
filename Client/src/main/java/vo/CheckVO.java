package vo;

import java.util.Vector;

public class CheckVO extends Vector<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CheckVO(String type,String orderNumber,String price,String place){
		this.add(type);
		this.add(orderNumber);
		this.add(price);
		this.add(place);
	}
	public String getType(){
		return get(0);
	}
	public String getOrderNumber(){
		return get(1);
	}
	public String getPrice(){
		return get(2);
	}
	public String getPlace(){
		return get(3);
	}
}
