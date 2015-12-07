package po;

import java.io.Serializable;

import po.receipts.*;

import java.util.ArrayList;

/**
 * Created by admin on 15/10/25.
 */
public class SalesPO implements Serializable {
    
	 	private ArrayList<IncomePO> income;
	    private ArrayList<PaymentPO> payment;
	    
	    public SalesPO(ArrayList<IncomePO> income, ArrayList<PaymentPO> payment){
	    	this.income=income;
	    	this.payment=payment;
	    }

	   public ArrayList<IncomePO> getIncomeList(){
		   return this.income;
	   } 
	   
	   public ArrayList<PaymentPO> getPaymentList(){
		   return this.payment;
	   }
	
}
