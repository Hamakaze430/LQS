package po.receipts;

import java.io.Serializable;
import java.util.ArrayList;

import po.OrderPO;
import po.ReceiptPOBase;

public class DeliverReceiptPO extends ReceiptPOBase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String deliver;
	private String location;
	private ArrayList<OrderPO> list;
	private String id;
	private String date;
	
	public DeliverReceiptPO(String id,String date, String location, String deliver, ArrayList<OrderPO> list){
		this.id="DeliverReceipt"+id;
		this.date=date;
		this.location = location;
		this.deliver=deliver;
		this.list = list;
	}
	
	public String getID(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getDeliver(){
		return deliver;
	}
	
	public void addOrderItem(OrderPO po){
		list.add(po);
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return list;
	}

}
