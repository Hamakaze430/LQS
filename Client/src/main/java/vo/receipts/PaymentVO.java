package vo.receipts;

import java.io.Serializable;

import po.receipts.PaymentPO;
import vo.ReceiptVO;

public class PaymentVO extends ReceiptVO implements Serializable{
	
	private String amount;
	
	PaymentVO(String name, String creator, String date, String status, String amount) {
		super(name, creator, date, status, "入款单");
		this.amount=amount;
	}
	
	public PaymentVO(PaymentPO paymentPO){
		super(paymentPO.getName(), paymentPO.getCreator(), paymentPO.getCreateDate(), 
				paymentPO.getStatus(), "入款单");
		amount=String.valueOf(paymentPO.getAmount());
//		this.add(String.valueOf(paymentPO.getAmount()));
	}

	public String getType(){
		return "入款单";
	}
	
	public String getAmount(){
		return amount;
	}
	
}
