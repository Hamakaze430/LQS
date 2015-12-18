package po;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Receiptsdata.Calculator;
import data.Receiptsdata.ReceiptsdataImpl;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;
/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitPO implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PaymentPO> payment;
	private ArrayList<IncomePO> income;
	private double totalPayment;
	private double totalIncome;
	private double totalProfit;
	
	public void setLists(String date){
		ReceiptsdataImpl rdi;
		try {
			rdi = new ReceiptsdataImpl();
			payment=rdi.getPaymentBeforeDate(date);
			income=rdi.getIncomeBeforeDate(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public void setTotal(){
    	Calculator cal=new Calculator(this.payment, this.income);
        this.totalPayment=cal.getPayment();
        this.totalIncome=cal.getIncome();
        this.totalProfit=cal.getProfit();
    }

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
