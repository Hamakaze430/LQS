package data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import po.*;
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

	public UserPO getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillManagementPO getBM() {
		// TODO Auto-generated method stub
		return null;
	}

	public SalesPO getSales() {
		// TODO Auto-generated method stub
		return null;
	}

	public CostBenefitPO getCB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName(){
		// TODO Auto-generated method stub
		return null;
	}

	public CarPO getCar() {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverPO getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityPO getCommodity() {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountPO getBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillManagementPO getBM(String date) {
		// TODO Auto-generated method stub
		return null;
	}
}
