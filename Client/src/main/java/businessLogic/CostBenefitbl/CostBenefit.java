package businessLogic.CostBenefitbl;

import po.CostBenefitPO;
import po.receipts.*;
import vo.CostBenefitVO;
import init.RMIHelper;

import java.util.ArrayList;

import dataService.CostBenefitdataService.CostBenefitdataService;
import dataService.DataFactoryService.DataFactoryService;
import businessLogicService.CostBenefitblService.CostBenefitblService;

public class CostBenefit implements CostBenefitblService{
	
	private DataFactoryService dataFactory;
	private CostBenefitdataService cbImpl;
	
	public CostBenefit(){
		dataFactory = RMIHelper.getDataFactory();
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
    
    public CostBenefitVO getVO(String date){
    	CostBenefitPO po=dataFactory.getCostBenefitdataService().getCostBenefitPO(date);
    	CostBenefitVO vo=new CostBenefitVO(po);
    	return vo;
    }

    public double showCost(String date){
        return this.getVO(date).getCost();
    }

    public double showBenefit(String date){
        return this.getVO(date).getBenefit();
    }

    public double showProfit(String date){
        return this.getVO(date).getProfit();
    }

    public String getReport(String date){
    	/*
    	 * 怎么导出报表……what报表…………
    	 * 
    	 * */
        return null;
    }

    public String cancelReport(){
    	
        return null;
    }

	public String getDate(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
