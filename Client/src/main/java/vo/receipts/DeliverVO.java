package vo.receipts;

import Miscellaneous.FormType;
import po.receipts.DeliverPO;
import po.receipts.LoadingPO;
import vo.ReceiptVO;

public class DeliverVO extends ReceiptVO {
	private String deliverer;
	private String order;
	
	public  DeliverVO(String name, String creator, String date, String deliverer, String order) {
		super(FormType.派件单.name(), name, creator, date);
		this.deliverer = deliverer;
		this.order = order;
		// TODO Auto-generated constructor stub
	}
	
	public  DeliverVO(DeliverPO po) {
		super(FormType.派件单.name(), po.getName(), po.getCreator(), po.getCreateDate());
		this.deliverer = po.getDeliverer();
		this.order = po.getOrder();
		// TODO Auto-generated constructor stub
	}
	
	public String getDeliverer(){
		return deliverer;
	}
	
	public String getOrder(){
		return order;
	}
	
	public DeliverPO toPO(long receiptId){
		return new DeliverPO(
				receiptId,getName(),getCreator(),
				getDate(),deliverer, order);
	}

}
