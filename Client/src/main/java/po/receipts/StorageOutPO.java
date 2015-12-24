package po.receipts;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class StorageOutPO extends ReceiptPO{

	String orderId;
	String end;
	String traffic;
	String outId;
	public StorageOutPO(long receiptId,String name, String creator, String date, 
			String id, String end, String traffic, String outId) {
		super(FormType.入库单.name(), name, creator, date, receiptId);
		// TODO Auto-generated constructor stub
		this.orderId = id;
		this.end = end;
		this.traffic = traffic;
		this.outId = outId;
	}
	public String getId(){
		return orderId;
	}
	public String getEnd(){
		return end;
	}
	public String getTraffic(){
		return traffic;
	}
	public String getOutId(){
		return outId;
	}

}
