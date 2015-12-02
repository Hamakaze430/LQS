package data.Receiptsdata;

import java.util.ArrayList;

import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public class Calculator {

	ArrayList<PaymentPO> payment;
    ArrayList<IncomePO> income;

    public Calculator(ArrayList<PaymentPO> payment, ArrayList<IncomePO> income){
        this.payment=payment;
        this.income=income;
    }

    public double getPayment(){
        double result=0.0;
        for(int i=0;i<payment.size();i++){
            result+=payment.get(i).getAmount();
        }
        return result;
    }

    public double getIncome(){
        double result=0.0;
        for(int i=0;i<income.size();i++){
            result+=income.get(i).getAmount();
        }
        return result;
    }

    public double getProfit(){
        return this.getIncome()-this.getPayment();
    }
    
}
