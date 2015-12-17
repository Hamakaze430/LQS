package po;

import java.io.Serializable;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public class ReceiptPO implements Serializable{
	String formType;
	String name;
	String creator;
	String createdate;
    String status;
    
    public ReceiptPO(String type,String n,String c,String cd,String rs){
    	formType = type;
    	name = n;
    	creator = c;
    	createdate = cd;
    	status = rs;
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
    	return formType;
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
}
