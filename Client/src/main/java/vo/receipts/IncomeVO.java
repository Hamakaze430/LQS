package vo.receipts;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import vo.ReceiptVO;


public class IncomeVO extends ReceiptVO{

private String amount;
	
	IncomeVO(String name, String creator, String date, String status, String amount) {
		super(name, creator, date, status);
		this.amount=amount;
	}
	
	public IncomeVO(IncomePO incomePO){
		super(incomePO.getName(), incomePO.getCreator(), incomePO.getCreateDate(), incomePO.getStatus());
		amount=incomePO.getAmount();
	}
	
}
