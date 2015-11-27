package dataService.CostBenefitdataService;

import po.*;
import java.rmi.*;

public interface CostBenefitdataService extends Remote{
	
	public CostBenefitPO getCostBenefitPO(String date);
		
}
