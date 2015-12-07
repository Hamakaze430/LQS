package vo.receipts;

import java.util.ArrayList;

import vo.OrderVO;

public class ArrivalReceiptVO {

	private String from;
	private String location;
	private ArrayList<OrderVO> list;
	private String id;
	private String date;
	
	public ArrivalReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> voList){
		this.id=id;
		this.date=date;
		this.from=from;
		this.location = location;
		this.list = voList;
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
	
	public String getFrom(){
		return from;
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return this.list;
	}


}
