package po;

import java.io.Serializable;

import Miscellaneous.ReceiptState;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalPO implements Serializable {
	public long hashId;
	public String name;
	public String date;
	public ReceiptState status;
	
	
	public ApprovalPO(String name,String date, ReceiptState status, long hashId){
		this.name=name;
		this.status = status;
		this.date=date;
		this.hashId = hashId;
	}
	
	public String getName(){
		return name;
	}
	public String getDate(){
		return date;
	}
	public ReceiptState getStatus(){
		return status;
	}
	public long getHashId(){
		return hashId;
	}
}

