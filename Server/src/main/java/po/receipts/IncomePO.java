package po.receipts;

import po.ReceiptPO;

/**
 * Created by admin on 15/11/16.
 */
public class IncomePO extends ReceiptPO {
	
    private String amount;

    public IncomePO(String n, String c, String cd, String rs, String a){
        super("收款单",n, c, cd, rs,);
        this.amount=a;
    }

    public double getAmount(){
        return Double.parseDouble(amount);
    }

}
