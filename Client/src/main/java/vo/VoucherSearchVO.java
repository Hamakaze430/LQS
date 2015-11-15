package vo;

/**
 * Created by admin on 15/10/25.
 */
public class VoucherSearchVO {
	private String date;
	private String hall;
	private double price;
	
	public VoucherSearchVO(String date,String hall,double price){
		this.date=date;
		this.hall=hall;
		this.price=price;
	}
	
	public void setHall(){
		this.hall=hall;
	}
	
	public void setDate(){
		this.date=date;
	}
	
	public double getPrice(){
		return price;
	}
}
