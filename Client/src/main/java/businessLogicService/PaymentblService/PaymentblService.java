package businessLogicService.PaymentblService;

import java.util.ArrayList;

import vo.receipts.PaymentVO;
import dataService.ResultMessage;

public interface PaymentblService {
    public ResultMessage  createReceipt(PaymentVO vo);
	
	public PaymentVO getPayment(String id);
	
	public ArrayList<PaymentVO> viewAll();
	
	public void endPayment();

}
