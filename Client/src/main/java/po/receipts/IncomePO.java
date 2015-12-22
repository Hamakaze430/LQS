package po.receipts;

import java.util.List;

import po.ReceiptPO;

/**
 * Created by admin on 15/11/16.
 */
public class IncomePO extends ReceiptPO {

<<<<<<< HEAD
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
	private String deliverer;
>>>>>>> 6ffb88fc514f4c42c263398ee465b506d6f70f9f
	private String amount;
	private List<String> orders;
	
//    public IncomePO(String n, String c, String cd, String rs, String a){
//        super(n, c, cd, rs, "收款单");
//        this.amount=a;
//    }
    
	public IncomePO(long receiptId, String name, String creator, String date, String amount, String deliverer, List<String> orders) {
		super("收款单", name, creator, date, receiptId);
		this.amount=amount;
		this.deliverer = deliverer;
		this.orders = orders;
	}
    
	
	public String getDeliverer(){
		return deliverer;
	}
	
	public List<String> getOrders(){
		return orders;
	}

    public String getAmount(){
        return amount;
    }

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
