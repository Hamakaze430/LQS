package po.receipts;

import java.util.List;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class ArrivalPO extends ReceiptPO {

	String hallId;
	String id;
	String startplace;
	List<String> orders;
	List<String> states;
	public ArrivalPO(long receiptId, String name, String creator, String date, String hallId, String id, String startplace, List<String> orders, List<String> states) {
		super(FormType.到达单.name(), name, creator, date, receiptId);
		this.hallId = hallId;
		this.id = id;
		this.startplace = startplace;
		this.orders = orders;
		this.states = states;
		// TODO Auto-generated constructor stub
	}
	public String getHallId(){
		return hallId;
	}
	
	public String getId(){
		return id;
	}
	
	public String getStartplace(){
		return startplace;
	}
	
	public List<String> getOrders(){
		return orders;
	}
	
	public List<String> getStates(){
		return states;
	}
	

}
