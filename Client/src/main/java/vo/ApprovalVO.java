package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String date;
	private String status;
	private long receiptId;
	public ApprovalVO(String name,String date, String status, long receiptId){
		this.name = name;
		this.date = date;
		this.status = status;
		this.receiptId = receiptId;
	}
	
	public String getName(){
		return name;
	}
	public String getDate(){
		return date;
	}
	
	public String getStatus(){
		return status;
	}
	public long getReceiptId(){
		return receiptId;
	}
	
}

