package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
	private String totalPayment;
	private String totalIncome;
	private String totalProfit;
	
	public void setLists(ArrayList<PaymentPO> pay, ArrayList<IncomePO> in){
		payment=pay;
		income=in;
	}
	
	public ArrayList<PaymentPO> getPaymentList(){
		return payment;
	}
	
	public ArrayList<IncomePO> getIncomeList(){
		return income;
	}
	
	public void setTotalPayment(double p){
		BigDecimal bd = new BigDecimal(String.valueOf(p));   
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);  
		totalPayment=String.valueOf(bd);
	}
	
	public void setTotalIncome(double i){
		BigDecimal bd = new BigDecimal(String.valueOf(i));   
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);  
		
		totalIncome=String.valueOf(bd);
	}
	
	public void setTotalProfit(double pr){
		BigDecimal bd = new BigDecimal(String.valueOf(pr));   
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);  
		totalProfit=String.valueOf(bd);
	}

    public String getTotalPayment(){
    	return this.totalPayment;
    }
    
    public String getTotalIncome(){
    	return this.totalIncome;
    }

    public String getProfit() {
    	return this.totalProfit;
    }
}
