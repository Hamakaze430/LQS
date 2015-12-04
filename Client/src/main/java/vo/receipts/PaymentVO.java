package vo.receipts;

import po.receipts.PaymentPO;
import vo.ReceiptVO;

public class PaymentVO extends ReceiptVO{
	
	private String amount;
	
	PaymentVO(String name, String creator, String date, String status, String amount) {
		super(name, creator, date, status);
		this.amount=amount;
	}
	
	public PaymentVO(PaymentPO po){
		super(po.getName(), po.getCreator(), po.getCreateDate(), po.getStatus());
		amount=po.getAmount();
	}
	
}
