package po.receipts;

import po.ReceiptPO;

/**
 * Created by admin on 15/11/16.
 */
public class IncomePO extends ReceiptPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String amount;

    public IncomePO(String n, String c, String cd, String rs, String a){
        super(n, c, cd, rs, "收款单");
        this.amount=a;
    }

    public double getAmount(){
        return Double.parseDouble(amount);
    }

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
