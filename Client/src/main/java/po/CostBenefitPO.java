package po;

import java.io.Serializable;
import java.util.ArrayList;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;
//import data.Receiptsdata.Calculator;
//import data.Receiptsdata.ReceiptsdataImpl;

/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitPO implements Serializable {
	private ArrayList<PaymentPO> payment;
	private ArrayList<IncomePO> income;
	private double totalPayment;
	private double totalIncome;
	private double totalProfit;
	
//	public void setLists(String date){
//		ReceiptsdataImpl rdi=new ReceiptsdataImpl();
//		payment=rdi.getPaymentBeforeDate(date);
//		income=rdi.getIncomeBeforeDate(date);
//	}
//	
//    public void setTotal(){
//    	Calculator cal=new Calculator(this.payment, this.income);
//        this.totalPayment=cal.getPayment();
//        this.totalIncome=cal.getIncome();
//        this.totalProfit=cal.getProfit();
//    }

    public double getTotalPayment(){
    	return this.totalPayment;
    }
    
    public double getTotalIncome(){
    	return this.totalIncome;
    }

    public double getProfit() {
    	return this.totalProfit;
    }
}
