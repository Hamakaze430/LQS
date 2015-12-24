package businessLogic.Approvalbl;

import java.util.List;

import Miscellaneous.Authorities;
import businessLogic.Approvalbl.MockTest.MockReceipt;
import businessLogic.Userbl.Userbl;
import businessLogicService.ApprovalblService.ApprovalblService;
import businessLogicService.ReceiptsblService.ReceiptsblService;
import businessLogicService.UserblService.UserblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.ApprovalPO;
import po.HallPO;
import po.ReceiptPO;
import vo.ApprovalVO;

public class Approvalbl implements ApprovalblService {
	private DataFactoryService dataFactory;
	public Approvalbl(){
		dataFactory = Client.dataFactory;
	}
	
	public void passReceipt(ReceiptPO po){
		
	}
	
	public void changeReceipt(ReceiptPO po){
		
	}

	public void showReceipt(ReceiptPO po){
		
	}
	public boolean insert(ApprovalPO po) {
		return dataFactory.getApprovaldataService().insert(po);
	}
	public List<ApprovalVO> findAll(){
		List<ApprovalPO> list = dataFactory.getApprovaldataService().findAll();
		return null;
	}

}
