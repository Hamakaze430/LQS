package vo.receipts;

import Miscellaneous.FormType;
import po.receipts.StorageOutPO;
import vo.ReceiptVO;

public class StorageOutVO extends ReceiptVO{

	String orderId;
	String end;
	String traffic;
	String outId;
	public StorageOutVO(String name, String creator, String date, 
			String id, String end, String traffic, String outId) {
		super(FormType.入库单.name(), name, creator, date);
		// TODO Auto-generated constructor stub
		this.orderId = id;
		this.end = end;
		this.traffic = traffic;
		this.outId = outId;
	}
	public StorageOutVO(StorageOutPO po){
		super(FormType.入库单.name(), po.getName(), po.getCreator(), po.getCreateDate());
		// TODO Auto-generated constructor stub
		this.orderId = po.getId();
		this.end = po.getEnd();	
		this.traffic = po.getTraffic();
		this.outId = po.getOutId();
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
	
	public StorageOutPO toPO(long receiptId){
		return new StorageOutPO(receiptId,getName(),getCreator(), getDate(),
				orderId, end, traffic, outId);
	}

}
