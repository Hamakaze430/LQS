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
	public final String date;
	
	public ReceivePO(long receiptId,String formname, String creator, String id, String receiver, String date){
		super(FormType.收件单.name(),formname,creator,date,receiptId);
		this.id = id;
		this.receiver = receiver;
		this.date = date;
	}
}
