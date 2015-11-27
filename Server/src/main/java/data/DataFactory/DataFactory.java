package data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.LogisticsInfoSearchdata.LogisticsDataServiceTextFileImpl;
import dataService.DataFactoryService.DataFactoryService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService{
	
	public DataFactory() throws RemoteException {
		
		super();
		System.out.println("new DataFactory()");
	}

	public LogisticsDataService getLogisticsDataService() throws RemoteException {
		LogisticsDataService data = new LogisticsDataServiceTextFileImpl();
		return data;
	}

}
