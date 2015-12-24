package vo.receipts;

import java.io.Serializable;
import java.util.List;

import po.receipts.PaymentPO;
import vo.ReceiptVO;

public class PaymentVO extends ReceiptVO implements Serializable{
	
	String account;
	String item;
    String amount;
    String memo;
	
	public PaymentVO(String name, String creator, String date, 
			String account, String amount, String item, String memo) {
		super( "付款单", name, creator, date);
		//this.amount=amount;
		this.amount=amount;
		this.account = account;
		this.item = item;
		this.memo = memo;
	}
	
	public PaymentVO(PaymentPO paymentPO){
		super(paymentPO.getType(),paymentPO.getName(), paymentPO.getCreator(), paymentPO.getCreateDate());
		this.amount=paymentPO.getAmount();
		this.account = paymentPO.getAccount();
		this.item = paymentPO.getItem();
		this.memo = paymentPO.getMemo();
//		this.add(String.valueOf(paymentPO.getAmount()));
	}

	public String getType(){
		return "入款单";
	}
	
	public String getAccount(){
		return account;
	}
	
	public String getAmount(){
		return amount;
	}
	
	public String getItem(){
		return item;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public PaymentPO toPO(long receiptId){
		return new PaymentPO(receiptId, getName(), getCreator(), getDate(), 
					account, amount, item, memo);
	}
	
}
