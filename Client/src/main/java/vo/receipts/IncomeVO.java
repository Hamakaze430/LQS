package vo.receipts;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import vo.ReceiptVO;
import java.util.Vector;

public class IncomeVO extends ReceiptVO{

private String amount;
	
	IncomeVO(String name, String creator, String date, String status, String amount) {
		super(name, creator, date, status, "收款单");
		//this.amount=amount;
		this.amount=amount;
	}
	
	public IncomeVO(IncomePO incomePO){
		super(incomePO.getName(), incomePO.getCreator(), incomePO.getCreateDate(), 
				incomePO.getStatus(), "收款单");
		amount=String.valueOf(incomePO.getAmount());
		//this.add(String.valueOf(incomePO.getAmount()));
	}
	
	public String getType(){
		return "收款单";
	}
	
	public String getAmount(){
		return amount;
	}
	
}
