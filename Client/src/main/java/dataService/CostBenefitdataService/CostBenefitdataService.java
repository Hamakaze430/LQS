package dataService.CostBenefitdataService;

import java.rmi.Remote;

import po.CostBenefitPO;

public interface CostBenefitdataService extends Remote{
	
	public CostBenefitPO getCostBenefitPO(String date);
	
	public boolean getReport(CostBenefitPO po);	
}
