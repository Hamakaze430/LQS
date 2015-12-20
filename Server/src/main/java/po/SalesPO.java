package po;

import java.io.Serializable;

import po.receipts.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by admin on 15/10/25.
 */
public class SalesPO implements Serializable {
    
    private ArrayList<IncomePO> income;
    private ArrayList<PaymentPO> payment;
    
    public SalesPO(){
    	
    }
    
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

   public ArrayList<ReceiptPO> getAll(){
	   ArrayList<ReceiptPO> receipt = new ArrayList<ReceiptPO>();
	   Iterator it=income.iterator();
	   while(it.hasNext()){
		   receipt.add((ReceiptPO) it.next());
	   }
	   it=payment.iterator();
	   while(it.hasNext()){
		   receipt.add((ReceiptPO) it.next());
	   }
	   return receipt;
   }
}
