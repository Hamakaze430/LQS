package po;

import java.io.Serializable;
import java.util.ArrayList;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;

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

//    public String getStartDate(){
//        return startDate;
//    }
//
//    public String getEndDate(){
//        return endDate;
//    }

}
