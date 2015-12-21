package businessLogic.Approvalbl;

import Miscellaneous.Authorities;
import businessLogic.Approvalbl.MockTest.MockReceipt;
import businessLogic.Userbl.Userbl;
import businessLogicService.ApprovalblService.ApprovalblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
import po.ApprovalPO;
import po.ReceiptPO;

public class Approvalbl implements ApprovalblService {
	private ReceiptsblService rs;
	public Approvalbl(){
	}
	
	public void passReceipt(ReceiptPO po){
		
	}
	
	public void changeReceipt(ReceiptPO po){
		
	}

	public void showReceipt(ReceiptPO po){
		
	}
	public boolean insert(ApprovalPO app) {
		// TODO Auto-generated method stub
		return false;
	}

}
