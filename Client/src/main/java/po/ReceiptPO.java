package po;

import java.io.Serializable;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public class ReceiptPO implements Serializable{
	
	private String name;
	private String creator;
	private String createdate;
    private String type;
    private long receiptId;
    
    public ReceiptPO(String type,String n,String c,String cd,String string){
    	name = n;
    	creator = c;
    	createdate = cd;
    	this.receiptId = string;
    	this.type=type;
    }
    
    private Boolean isIncome(){
    	if(this.getClass().equals(IncomePO.class))
    		return true;
    	else
    		return false;
    }
    
    private Boolean isPayment(){
    	if(this.getClass().equals(PaymentPO.class))
    		return true;
    	else
    		return false;
    }
    
    public String getType(){
    	return type;
    }
    
    public String getName(){
    	return name;
    }
    
    public String getCreator(){
    	return creator;
    }
    
    public String getCreateDate(){
    	return createdate;
    }

	
	public long getReceiptId(){
		return receiptId;
	}
}
