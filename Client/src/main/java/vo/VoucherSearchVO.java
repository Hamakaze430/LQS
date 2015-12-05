package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class VoucherSearchVO extends Vector<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VoucherSearchVO(String hall,String date,String price){
		this.add(hall);
		this.add(date);
		this.add(price);
	}

	public String getHall(){
		return get(0);
	}

	public String getDate(){
		return get(1);
	}
	public String getPrice(){
		return get(2);
	}
}
