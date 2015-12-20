package vo;

import java.util.Date;
import java.util.Vector;

import Miscellaneous.ReceiptState;

import java.io.Serializable;

import po.ReceiptPO;

/**
 * Created by admin on 15/10/25.
 */
public class ReceiptVO /*extends Vector<String>*/ implements Serializable{
    private String type;
    private String date;
    private ReceiptState state;
    
    private String name;
    private String creator;
    private String createdate;
    private String status;
    
    
    ReceiptVO(ReceiptPO po){
//    	this.add(po.getName());
//    	this.add(po.getCreator());
//    	this.add(po.getCreateDate());
//    	this.add(po.getStatus());
//    	this.add(po.getType());
    	name=po.getName();
    	creator=po.getCreator();
    	date=po.getCreateDate();
    	status=po.getStatus();
    }
    
    protected ReceiptVO(String name, String creator, String date, 
    		String status, String type){
//    	this.add(name);
//    	this.add(creator);
//    	this.add(date);
//    	this.add(status);
//    	this.add(type);
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
