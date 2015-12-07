package businessLogic.CostBenefitbl;

import po.CostBenefitPO;
import po.receipts.*;
import vo.CostBenefitVO;
import init.Client;
import init.RMIHelper;

import java.util.ArrayList;

import dataService.CostBenefitdataService.CostBenefitdataService;
import dataService.DataFactoryService.DataFactoryService;
import businessLogicService.CostBenefitblService.CostBenefitblService;

public class CostBenefit implements CostBenefitblService{
	
	private DataFactoryService dataFactory;
	private CostBenefitdataService cbImpl;
	private String date;
	
	public CostBenefit(){
		dataFactory = Client.dataFactory;
		cbImpl=dataFactory.getCostBenefitdataService();
	}
	
//    String message;
//    int cost;
//    int benefit;
//    int profit;
//    ArrayList<PaymentPO> payment=new ArrayList<PaymentPO>();
//    ArrayList<IncomePO> income=new ArrayList<IncomePO>();
//    ReceiptsGetter rg=new ReceiptsGetter();
//    Calculator calculator=new Calculator(payment, income);

//    public String getDate(String message){
//        if(message.equals("get")){  //get date and pass on to calculator
//            Calendar c=Calendar.getInstance();
//            int year=c.get(Calendar.YEAR);
//            int month=c.get(Calendar.MONTH);
//            int day=c.get(Calendar.DATE);
//            String date=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
//            return date;
//        }
//        else
//            return null;
//    }
	
	public void setDate(String date){
		this.date=date;
	}
    
    public CostBenefitVO getVO(){
    	CostBenefitPO po=cbImpl.getCostBenefitPO(date);
    	CostBenefitVO vo=new CostBenefitVO(po);
    	return vo;
    }

    public String showCost(){
        return this.getVO().getCost();
    }

    public String showBenefit(){
        return this.getVO().getBenefit();
    }

    public String showProfit(){
        return this.getVO().getProfit();
    }
    
    public void getReport(){
    	cbImpl.getReport(cbImpl.getCostBenefitPO(date));
    }

}
