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
<<<<<<< HEAD
		//rs = new MockReceipt(new Userbl());
=======
		
>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
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
