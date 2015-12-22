package po.receipts;

import po.ReceiptPO;

/**
 * Created by admin on 15/11/16.
 */
public class PaymentPO extends ReceiptPO {
<<<<<<< HEAD

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String amount;
=======
	
	String account;
	String item;
    String amount;
    String memo;
>>>>>>> 6ffb88fc514f4c42c263398ee465b506d6f70f9f

    public PaymentPO(long receiptId, String name, String creator, String date, 
			String account, String amount, String item, String memo) {
		super( "付款单", name, creator, date, receiptId);
		//this.amount=amount;
		this.amount=amount;
		this.account = account;
		this.item = item;
		this.memo = memo;
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

}

