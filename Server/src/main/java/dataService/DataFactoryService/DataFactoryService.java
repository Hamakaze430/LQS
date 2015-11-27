package dataService.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;

public interface DataFactoryService extends Remote {
	
	LogisticsDataService getLogisticsDataService() throws RemoteException;
}
