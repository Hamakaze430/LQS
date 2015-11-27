package data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.LogisticsInfoSearchdata.LogisticsDataServiceTextFileImpl;
import dataService.DataFactoryService.DataFactoryService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;

public class DataFactory implements DataFactoryService{

	@Override
	public LogisticsDataService getLogisticsDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
