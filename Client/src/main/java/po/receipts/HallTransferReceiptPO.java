package po.receipts;

import java.io.Serializable;
import java.util.ArrayList;

import po.OrderPO;
import po.ReceiptPOBase;
import Miscellaneous.ReceiptState;

public class HallTransferReceiptPO extends ReceiptPOBase implements Serializable{
	private static final long serialVersionUID = 1L;
	private String location;
	private String hallID;
	private String transportID;
	private String to;
	private String carID;
	private String supervisor;
	private String guard;
	private ArrayList<OrderPO> orderlist;
	private String id;
	private String date;
	private ReceiptState state;
	
	public HallTransferReceiptPO(String id, String location, String date,String hallID,String transportID,String to, String carID,
			String supervisor,String guard,ArrayList<OrderPO> orderlist){
		
		this.id = "HallTransferReceipt"+id;
		this.date=date;
		this.state = ReceiptState.未审批;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
		this.orderlist = orderlist;
		
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
	
	public String getHallID(){
		return hallID;
	}
	
	public String getTransportID(){
		return transportID;
	}
	
	public String getDestination(){
		return to;
	}
	
	public String getCarID(){
		return carID;
	}
	
	public String getSupervisor(){
		return supervisor;
	}
	
	public String getGuard(){
		return guard;
	}
	
	public ArrayList<OrderPO> getOrderlist(){
		return orderlist;
	}


}
