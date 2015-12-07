package vo.receipts;

import java.io.Serializable;

import po.receipts.PaymentPO;
import vo.ReceiptVO;

public class PaymentVO extends ReceiptVO implements Serializable{
	
	private String amount;
	
	public PaymentVO(String name, String creator, String date, String status, String amount) {
		super(name, creator, date, status);
		this.amount=amount;
	}
	
	public PaymentVO(PaymentPO po){
		super(po.getName(), po.getCreator(), po.getCreateDate(), po.getStatus());
		amount=po.getAmount();
	}


}
