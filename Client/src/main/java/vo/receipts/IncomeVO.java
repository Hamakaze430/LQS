package vo.receipts;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import vo.ReceiptVO;

import java.util.List;
import java.util.Vector;

public class IncomeVO extends ReceiptVO{

	private String deliverer;
	private String amount;
	private List<String> orders;

	public IncomeVO(String name, String creator, String date, String amount, String deliverer, List<String> orders) {
		super( "收款单", name, creator, date);
		//this.amount=amount;
		this.amount=amount;
		this.deliverer = deliverer;
		this.orders = orders;
	}
	
	public IncomeVO(IncomePO incomePO){
		super(incomePO.getType(), incomePO.getName(), 
				incomePO.getCreator(), incomePO.getCreateDate() );
		this.amount = incomePO.getAmount();
		this.deliverer = incomePO.getDeliverer();
		this.orders = incomePO.getOrders();
		//this.add(String.valueOf(incomePO.getAmount()));
	}
	
	public String getType(){
		return "收款单";
	}
	
	public String getDeliverer(){
		return deliverer;
	}
	
	public List<String> getOrders(){
		return orders;
	}
	
	public String getAmount(){
		return amount;
	}


}

