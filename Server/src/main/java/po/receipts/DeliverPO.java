package po.receipts;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class DeliverPO extends ReceiptPO {
	private String deliverer;
	private String order;
	
	public  DeliverPO(long receiptId, String name, String creator, String date, String deliverer, String order) {
		super(FormType.派件单.name(), name, creator, date, receiptId);
		this.deliverer = deliverer;
		this.order = order;
		// TODO Auto-generated constructor stub
	}
	
	public String getDeliverer(){
		return deliverer;
	}
	
	public String getOrder(){
		return order;
	}

}
