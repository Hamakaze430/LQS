package dataService.DataFactoryService;

import po.*;

public interface DataFactoryService {
	
	//i have...no idea what this is doing, but...
	
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
