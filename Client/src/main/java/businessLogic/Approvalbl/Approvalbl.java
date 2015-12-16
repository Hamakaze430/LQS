package businessLogic.Approvalbl;

import businessLogic.Approvalbl.MockTest.MockReceipt;
import businessLogic.Userbl.Userbl;
import businessLogicService.ApprovalblService.ApprovalblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import po.ReceiptPO;

public class Approvalbl implements ApprovalblService {
	private ReceiptsblService rs;
	
	public Approvalbl(){
		rs = new MockReceipt(new Userbl());
	}
	public void passReceipt(ReceiptPO po){
		
	}
	
	public void changeReceipt(ReceiptPO po){
		
	}
	public String getName(){
		return rs.getName();
	}
	public String getCreater(){
		return rs.getCreater();
	}

	public void showReceipt(ReceiptPO po){
		
	}

}
