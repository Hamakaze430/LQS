package po.receipts;

import java.util.List;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class TransferPO extends ReceiptPO {

	private String id;
	private String traffic; //飞机 or 铁路 or 公路
	private String number; //列次号
	private String startplace;
	private String destination;
	private String container;
	private String spyername;
	private List<String> orders;
	private String cost;
	public TransferPO(long receiptId, String name, String creator, String date, 
			String id, String traffic, String number, 
			String startplace, String destination, String container, String spyername,
			List<String> orders, String cost) {
		super(FormType.中转单.name(), name, creator, date, receiptId);
		this.id = id;
		this.traffic = traffic;
		this.number = number;
		this.startplace = startplace;
		this.destination = destination;
		this.container = container;
		this.spyername = spyername;
		this.orders = orders;
		this.cost = cost;
		// TODO Auto-generated constructor stub
	}
	
	public String getId(){
		return id;
	}
	
	public String getTraffic(){
		return traffic;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getStartplace(){
		return startplace;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public String getContainer(){
		return container;
	}
	
	public String getSpyername(){
		return spyername;
	}
	
	public List<String> getOrders(){
		return orders;
	}
	
	public String getCost(){
		return cost;
	}
	
	

}
