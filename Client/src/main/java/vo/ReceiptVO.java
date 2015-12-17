package vo;

import java.util.Date;

import Miscellaneous.ReceiptState;

import java.io.Serializable;

import po.ReceiptPO;

/**
 * Created by admin on 15/10/25.
 */
public class ReceiptVO implements Serializable{
    private String date;
    private ReceiptState state;
    
    private String type;//单据类型
    private String name; //单据名
    private String creator; //建单人
    private String createdate; //建单时间
    private String status; //单据是否审批状态
    
    ReceiptVO(ReceiptPO po){
    	name=po.getName();
    	creator=po.getCreator();
    	date=po.getCreateDate();
    	status=po.getStatus();
    }
    
    protected ReceiptVO(String type, String name, String creator, String date, String status){
    	this.type = type;
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
