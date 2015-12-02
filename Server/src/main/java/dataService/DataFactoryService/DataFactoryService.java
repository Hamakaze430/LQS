package dataService.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.CostBenefitdataService.CostBenefitdataService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import po.*;

public interface DataFactoryService extends Remote {
	
	LogisticsDataService getLogisticsDataService() throws RemoteException;
	
	CostBenefitdataService getCostBenefitdataService() throws RemoteException;
	
}
