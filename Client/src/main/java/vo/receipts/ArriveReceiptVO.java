package vo.receipts;

import java.util.ArrayList;

import vo.OrderVO;

public class ArriveReceiptVO {
	String id;
	String date;
	String from;
	String location;
	
	ArrayList<OrderVO> orderList;
	
	public ArriveReceiptVO(String id, String date, String from, String location, ArrayList<OrderVO> list){
		
		this.id =id;
		this. date = date;
		this.from = from;
		this.location = location;
		
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getFrom(){
		return this.from;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public ArrayList<OrderVO> getList(){
    	return this.orderList;
    }
	

}
