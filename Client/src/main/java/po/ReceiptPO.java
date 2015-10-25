package po;

import java.io.Serializable;

public class ReceiptPO implements Serializable{
	String name;
	String creator;
	String createdate;
    String receiptstatus;
    
    public ReceiptPO(String n,String c,String cd,String rs){
    	name = n;
    	creator = c;
    	createdate = cd;
    	receiptstatus = rs;
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
    
    public String getReceiptStatus(){
    	return receiptstatus;
    }
}
