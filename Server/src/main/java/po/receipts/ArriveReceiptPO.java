package po.receipts;

import java.io.Serializable;
import java.util.ArrayList;

import po.OrderPO;
import po.ReceiptPO;
import po.ReceiptPOBase;

public class ArriveReceiptPO extends ReceiptPOBase  implements Serializable{

private static final long serialVersionUID = 1L;
	
    String id;
    String date;
	String from;
	String location;
	
	boolean isHandle;
	
	ArrayList<OrderPO> order_list;
	
	public ArriveReceiptPO(String id, String date, String from, String location, ArrayList<OrderPO> order_list){
		this.id = "ArriveReceipt"+id;
		this.date = date;
		this.from = from;
		this.location = location;
		
		this.isHandle = false;
		
		this.order_list = order_list;
	}
	
	
	
	public String getFrom(){
		return from;
	}
	
	public String getLocation(){
		return location;
	}
	
	public boolean isHandle(){
		return this.isHandle;
	}
	
	public void handle(){
		this.isHandle = true;
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return order_list;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}



	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}
}
