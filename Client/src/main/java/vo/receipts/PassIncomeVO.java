package vo.receipts;

import java.util.Vector;

public class PassIncomeVO extends Vector<String> {
	
	public PassIncomeVO(IncomeVO vo){
		this.add(vo.getType());
		this.add(vo.getDate());
		this.add(vo.getCreator());
		this.add(vo.getAmount());
	}
	
}
