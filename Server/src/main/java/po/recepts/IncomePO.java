package po.recepts;

import po.ReceiptPO;

/**
 * Created by admin on 15/11/16.
 */
public class IncomePO extends ReceiptPO {

    String amount;

    public IncomePO(String n, String c, String cd, String rs, String a){
        super(n, c, cd, rs);
        this.amount=a;
    }

    public double getAmount(){
        return Double.parseDouble(amount);
    }

}
