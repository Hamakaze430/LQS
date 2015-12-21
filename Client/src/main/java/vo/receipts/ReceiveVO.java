/**
 * 收件单
 */
package vo.receipts;
import java.util.List;
import Miscellaneous.FormType;
import po.ReceiptPO;
import po.receipts.LoadingPO;
import po.receipts.ReceivePO;
import vo.ReceiptVO;

public class ReceiveVO extends ReceiptVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String id;
	public final String receiver;
	public final String date;
	
	public ReceiveVO(String formname, String creator, String id, String receiver, String date){
		super(FormType.收件单.name(),formname,creator,date);
		this.id = id;
		this.receiver = receiver;
		this.date = date;
	}	

	
	public ReceivePO toPO(long receiptId){
		return new ReceivePO(receiptId,getName(),getCreator(),id,receiver,date);
	}
	
	
	
}
