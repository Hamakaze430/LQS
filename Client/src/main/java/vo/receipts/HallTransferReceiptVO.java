package vo.receipts;

import java.util.ArrayList;

import vo.OrderVO;

public class HallTransferReceiptVO {
	private String location;
	private String hallID;
	private String transportID;
	private String to;
	private String carID;
	private String supervisor;
	private String guard;
	private ArrayList<OrderVO> orderlist;
	private String date;
	private String id;
	
	public HallTransferReceiptVO(String id, String location, String date,String hallID,String transportID,String to, String carID,
			String supervisor,String guard, ArrayList<OrderVO> orderlist){
		
		this.date=date;
		this.hallID=hallID;
		this.transportID=transportID;
		this.to=to;
		this.carID=carID;
		this.supervisor=supervisor;
		this.guard=guard;
		this.id =id;
		this.orderlist = orderlist;
		
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
	
	public ArrayList<OrderVO> getOrderlist(){
		return orderlist;
	}

}
