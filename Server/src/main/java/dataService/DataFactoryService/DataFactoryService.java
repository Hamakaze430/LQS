package dataService.DataFactoryService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import po.*;

public interface DataFactoryService extends Remote {
	
	LogisticsDataService getLogisticsDataService() throws RemoteException;
	
	public UserPO getUser();
	
	public BillManagementPO getBM(String date);
	
	public SalesPO getSales();
	
	public CostBenefitPO getCB();
	
	public String getName();
	
	public CarPO getCar();
	
	public DriverPO getDriver();
	
	public CommodityPO getCommodity();
	
	public BankAccountPO getBankAccount();
	
	//public void saveBMPO(BillManagementPO bm);
	
	public ReceiptPO getReceiptbyDate(String date);
	
	public void writeLog(String log);
}
