package vo.receipts;

import java.util.List;

import Miscellaneous.FormType;
import po.receipts.TransferPO;
import vo.ReceiptVO;

public class TransferVO extends ReceiptVO {

	private String id;
	private String traffic; //飞机 or 铁路 or 公路
	private String number; //列次号
	private String startplace;
	private String destination;
	private String container;
	private String spyername;
	private List<String> orders;
	private String cost;
	public TransferVO(String name, String creator, String date, 
			String id, String traffic, String number, 
			String startplace, String destination, String container, String spyername,
			List<String> orders, String cost) {
		super(FormType.中转单.name(), name, creator, date);
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
	
	public TransferVO(TransferPO po) {
		super(FormType.中转单.name(), po.getName(),po.getCreator(),po.getCreateDate());
		this.id = po.getId();
		this.traffic = po.getTraffic();
		this.number = po.getNumber();
		this.startplace = po.getStartplace();
		this.destination = po.getDestination();
		this.container = po.getContainer();
		this.spyername = po.getSpyername();
		this.orders = po.getOrders();
		this.cost = po.getCost();
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
	
	public TransferPO toPO(long receiptId){
		return new TransferPO(receiptId,getName(), getCreator(), getDate(),
				id, traffic, number, startplace, destination, container, spyername, orders, cost);
	}

}
