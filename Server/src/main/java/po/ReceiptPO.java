package po;

import java.io.Serializable;

import po.receipts.*;

public class ReceiptPO implements Serializable{
	
	private String name;
	private String creator;
	private String createdate;
	private String status;
	private double amount;
    private String type;
	
    public ReceiptPO(String n,String c,String cd,String rs, String type){
    	name = n;
    	creator = c;
    	createdate = cd;
    	status = rs;
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
    
    public String getName(){
    	return name;
    }
    
    public String getCreator(){
    	return creator;
    }
    
    public String getCreateDate(){
    	return createdate;
    }
    
    public String getStatus(){
    	return status;
    }

	public double getAmount() {
		return amount;
	}
	
	public String getType(){
		return type;
	}
}
