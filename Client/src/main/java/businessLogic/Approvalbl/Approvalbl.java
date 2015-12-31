package businessLogic.Approvalbl;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Authorities;
import businessLogic.Approvalbl.MockTest.MockReceipt;
import businessLogic.Receiptsbl.Receiptsbl;
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
	private ReceiptsblService receipt;
	public Approvalbl(){
		dataFactory = Client.dataFactory;
		receipt = new Receiptsbl();
	}
	
	public void passReceipt(long receiptId){
		
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
		List<ApprovalVO> ans = new ArrayList<ApprovalVO>();
		for (ApprovalPO po: list){
			ans.add(new ApprovalVO(po.getName(),po.getDate(),po.getStatus().name(),po.getHashId()));
		}
		return ans;
	}

	public boolean getPassed(ApprovalVO vo) {	
		dataFactory.getApprovaldataService().delete(vo.getReceiptId());
		receipt.pass(vo.getReceiptId());
		return true;
	}

}
