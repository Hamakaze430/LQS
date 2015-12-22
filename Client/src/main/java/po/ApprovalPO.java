package po;

import java.io.Serializable;

import Miscellaneous.ReceiptState;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalPO implements Serializable {
	public long hashId;
	public String name;
	public String creater;
	public ReceiptState status;
	
	
	public ApprovalPO(String name,String creater, ReceiptState status, long hashId){
		this.name=name;
		this.status = status;
		this.creater=creater;
		this.hashId = hashId;
	}
	
	public String getName(){
		return name;
	}
	public String getCreater(){
		return creater;
	}
	public ReceiptState getStatus(){
		return status;
	}
	public long getHashId(){
		return hashId;
	}
}

