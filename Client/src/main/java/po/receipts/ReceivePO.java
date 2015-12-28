package po.receipts;

import Miscellaneous.FormType;
import po.ReceiptPO;

public class ReceivePO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String id;
	public final String receiver;
	
	public ReceivePO(long receiptId,String formname, String creator, String date, String id, String receiver){
		super(FormType.收件单.name(),formname,creator,date,receiptId);
		this.id = id;
		this.receiver = receiver;
	}
	
	public String getId(){
		return id;
	}
	public String getReceiver(){
		return receiver;
	}
}
