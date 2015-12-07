package po.receipts;

import java.io.Serializable;
import java.util.ArrayList;

import po.OrderPO;
import Miscellaneous.ReceiptState;

public class ArrivalReceiptPO implements Serializable{
	private static final long serialVersionUID = -5743990485972024749L;

	private String from;
	private String location;
	private ArrayList<OrderPO> orderList;
	private String id;
	private String date;
	private ReceiptState  state;
	
	public ArrivalReceiptPO(String id, String date, String from, String location, ArrayList<OrderPO> poList){
		this.id="ArrivalReceipt"+id;
		this.date=date;
		this.from=from;
		this.location = location;
		this.state=ReceiptState.未审批;
		this.orderList = poList;
	}

	public String getID(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public ReceiptState getState(){
		return state;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getFrom(){
		return from;
	}
	
	public ArrayList<OrderPO> getOrderList(){
		return orderList;
	}

}
