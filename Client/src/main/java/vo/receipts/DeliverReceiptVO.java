package vo.receipts;

import java.util.ArrayList;

import vo.OrderVO;

public class DeliverReceiptVO {
	private String deliver;
	private String location;
	private ArrayList<OrderVO> list;
	private String id;
	private String date;
	
	public DeliverReceiptVO(String id,String date, String location, String deliver, ArrayList<OrderVO> list){
		this.id=id;
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
	
	public void resetOrderDeliver(){
			for(OrderVO ordervo:list){
				ordervo.setDeliver(deliver);;
			}
	}
	
	public void addOrderItem(OrderVO vo){
		list.add(vo);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		return list;
	}
	

}
