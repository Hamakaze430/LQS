package vo.receipts;

import java.util.Vector;

public class PassPaymentVO extends Vector<String> {
	
	public PassPaymentVO(PaymentVO vo){
		this.add(vo.getType());
		this.add(vo.getDate());
		this.add(vo.getCreator());
		this.add(vo.getAmount());
	}
	
}