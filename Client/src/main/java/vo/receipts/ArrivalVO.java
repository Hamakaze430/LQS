package vo.receipts;

import java.util.List;

import Miscellaneous.FormType;
import po.receipts.ArrivalPO;
import vo.ReceiptVO;

public class ArrivalVO extends ReceiptVO {

	String hallId;
	String id;
	String startplace;
	List<String> orders;
	List<String> states;
	public ArrivalVO(String name, String creator, String date, String hallId, String id, String startplace,List<String> orders, List<String> states) {
		super(FormType.到达单.name(), name, creator, date);
		this.hallId = hallId;
		this.id = id;
		this.startplace = startplace;
		this.orders = orders;
		this.states = states;
		// TODO Auto-generated constructor stub
	}
	
	public ArrivalVO(ArrivalPO po) {
		super(FormType.到达单.name(), po.getName(), po.getCreator(), po.getCreateDate());
		this.hallId = po.getHallId();
		this.id = po.getId();
		this.startplace = po.getStartplace();
		this.orders = po.getOrders();
		this.states = po.getStates();
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
	
	public ArrivalPO toPO(long receiptId){
		return new ArrivalPO(receiptId, getName(), getCreator(), getDate(),
				hallId, id, startplace, orders, states);
	}

}
