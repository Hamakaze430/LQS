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
	
	public ReceiveVO(String formname, String creator,String date, String id, String receiver ){
		super(FormType.收件单.name(),formname,creator,date);
		this.id = id;
		this.receiver = receiver;
	}
	
	public ReceiveVO(ReceivePO po){
		super(FormType.收件单.name(),po.getName(),po.getCreator(),po.getCreateDate());
		this.id = po.getId();
		this.receiver = po.getReceiver();
	}

	public String getId(){
		return id;
	}
	public String getReceiver(){
		return receiver;
	}
	
	public ReceivePO toPO(long receiptId){
		return new ReceivePO(receiptId,getName(),getCreator(),getDate(),id,receiver);
	}
	
	
	
}
