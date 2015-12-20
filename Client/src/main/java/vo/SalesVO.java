package vo;

import java.io.Serializable;

import po.*;
import po.receipts.*;

import java.util.ArrayList;
import java.util.Vector;

import vo.receipts.*;

/**
 * Created by admin on 15/10/25.
 */
public class SalesVO extends Vector<String>{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<IncomeVO> income=new ArrayList<IncomeVO>();
	private ArrayList<PaymentVO> payment=new ArrayList<PaymentVO>();
	    
	 public SalesVO(SalesPO po){
		ArrayList<IncomePO> income=po.getIncomeList(); 
		ArrayList<PaymentPO> payment=po.getPaymentList();

		for(int i=0;i<income.size();i++){
			IncomeVO tempvo=new IncomeVO(income.get(i));
			this.income.add(tempvo);
			//System.out.println(this.income.get(i).getDate());
		}
		for(int i=0;i<payment.size();i++){
			this.payment.add(new PaymentVO(payment.get(i)));
			//System.out.println(this.payment.get(i).getDate());
		}
	 }

	 public SalesVO(String type,String date,String name,String cost) {
		 this.add(type);
		 this.add(date);
		 this.add(name);
		 this.add(cost);
	}
	 public String getType(){
		 return get(0);
	 }
	 public String getDate(){
		 return get(1);
	 }
	 public String getName(){
		 return get(2);
	 }
	 public String getCost(){
		 return get(3);
	 }
	 public ArrayList<IncomeVO> getIncomeList(){
		 return this.income;
	 } 
	   
	 public ArrayList<PaymentVO> getPaymentList(){
	   return this.payment;
	 }
}
