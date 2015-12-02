package data.DataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.*;
import data.Approvaldata.Approvaldata;
import data.BankAccountdata.BankAccountdataImpl;
import data.BillManagementdata.BillManagementdataImpl;
import data.CarAndDriverdata.CarAndDriverdata;
import data.Commoditydata.CommoditydataImpl;
import data.CostBenefitdata.CostBenefitdataImpl;
import data.LogisticsInfoSearchdata.LogisticsDataServiceTextFileImpl;
import data.Receiptsdata.ReceiptsdataImpl;
import data.Salesdata.SalesdataImpl;
import data.Strategydata.Strategydata;
import data.Userdata.UserdataImpl;
import data.VoucherSearchdata.VoucherSearchdata;
import dataService.ApprovaldataService.ApprovaldataService;
import dataService.BankAccountdataService.BankAccountdataService;
import dataService.BillManagementdataService.BillManagementdataService;
import dataService.CarAndDriverdataService.CarAndDriverdataService;
import dataService.CommoditydataService.CommoditydataService;
import dataService.CostBenefitdataService.CostBenefitdataService;
import dataService.DataFactoryService.DataFactoryService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import dataService.ReceiptsdataService.ReceiptsdataService;
import dataService.SalesdataService.SalesdataService;
import dataService.StrategydataService.StrategydataService;
import dataService.UserdataService.UserdataService;
import dataService.VoucherSearchdataService.VoucherSearchdataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService{
	
	public DataFactory() throws RemoteException {
		super();
		System.out.println("new DataFactory()");
	}
	
	public ApprovaldataService getApprovaldataService() throws RemoteException{
		ApprovaldataService approval=new Approvaldata();
		return approval;
	}
	
	public BankAccountdataService getBankAccountdataService() throws RemoteException{
		BankAccountdataService account=new BankAccountdataImpl();
		return account;
	}

	public BillManagementdataService getBillManagementdataService() throws RemoteException{
		BillManagementdataService bill=new BillManagementdataImpl();
		return bill;
	} 
	
	public CarAndDriverdataService getCarAndDriverdataService() throws RemoteException{
		CarAndDriverdataService cd=new CarAndDriverdata();
		return cd;
	}

	public CommoditydataService getCommoditydataService() throws RemoteException{
		CommoditydataService commo=new CommoditydataImpl();
		return commo;
	} 
	
	public CostBenefitdataService getCostBenefitdataService() throws RemoteException{
		CostBenefitdataService cb=new CostBenefitdataImpl();
		return cb;
	}
	
	public LogisticsDataService getLogisticsDataService() throws RemoteException {
		LogisticsDataService data = new LogisticsDataServiceTextFileImpl();
		return data;
	}
	
	public ReceiptsdataService getReceiptsdataService() throws RemoteException{
		ReceiptsdataService receipts=new ReceiptsdataImpl();
		return receipts;
	}
	
	public SalesdataService getSalesdataService() throws RemoteException{
		SalesdataService sales=new SalesdataImpl();
		return sales;
	}
	
	public StrategydataService getStrategydataService() throws RemoteException{
		StrategydataService st=new Strategydata();
		return st;
	} 
	
	public UserdataService getUserdataService() throws RemoteException{
		UserdataService user=new UserdataImpl();
		return user;
	} 
	
	public VoucherSearchdataService getVoucherSearchdataService() throws RemoteException{
		VoucherSearchdataService voucher=new VoucherSearchdata();
		return voucher;
	} 
	
}
