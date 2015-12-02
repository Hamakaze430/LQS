package vo;

import java.io.Serializable;
import po.*;
import po.receipts.*;
import java.util.ArrayList;
import vo.receipts.*;

/**
 * Created by admin on 15/10/25.
 */
public class SalesVO implements Serializable{
	
	 private ArrayList<IncomeVO> income;
	 private ArrayList<PaymentVO> payment;
	    
	 public SalesVO(SalesPO po){
		ArrayList<IncomePO> income=po.getIncomeList(); 
		ArrayList<PaymentPO> payment=po.getPaymentList();
		for(int i=0;i<income.size();i++){
			this.income.add(new IncomeVO(income.get(i)));
		}
		for(int i=0;i<payment.size();i++){
			this.payment.add(new PaymentVO(payment.get(i)));
		}
	 }

	 public SalesVO() {

	}

	public ArrayList<IncomeVO> getIncomeList(){
		 return this.income;
	 } 
	   
	 public ArrayList<PaymentVO> getPaymentList(){
	   return this.payment;
	 }
}
