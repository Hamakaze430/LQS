package vo;

import java.util.Date;
import java.io.Serializable;

import po.ReceiptPO;

/**
 * Created by admin on 15/10/25.
 */
public class ReceiptVO implements Serializable{
    private String type;
    private String date;
    private ReceiptState state;
    
    private String name;
    private String creator;
    private String createdate;
    private String status;
    
    ReceiptVO(ReceiptPO po){
    	name=po.getName();
    	creator=po.getCreator();
    	date=po.getCreateDate();
    	status=po.getStatus();
    }
    
    protected ReceiptVO(String name, String creator, String date, String status){
    	this.name=name;
    	this.creator=creator;
    	createdate=date;
    	this.status=status;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public String getCreator(){
    	return this.creator;
    }
    
    public String getDate(){
    	return createdate;
    }
    
    public String getStatus(){
    	return this.status;
    }
 
    public String getType(){
        return type;
    }
}
