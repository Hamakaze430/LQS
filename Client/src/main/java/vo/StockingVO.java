package vo;

import java.util.Vector;

public class StockingVO extends Vector<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockingVO(String orderNumber,String date,String destination,String qu,String pai,String jia,String wei){
		this.add(orderNumber);
		this.add(date);
		this.add(destination);
		this.add(qu);
		this.add(pai);
		this.add(jia);
		this.add(wei);
	}
	public String getOrderNumber(){
		return get(0);
	}
	public String getDate(){
		return get(1);
	}
	public String getDestination(){
		return get(2);
	}
	public String getQu(){
		return get(3);
	}
	public String getPai(){
		return get(4);
	}
	public String getJia(){
		return get(5);
	}
	public String getWei(){
		return get(6);
	}
}
