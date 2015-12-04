package dataService.DataFactoryService;

import java.rmi.Remote;
<<<<<<< HEAD
import dataService.ApprovaldataService.ApprovaldataService;
import dataService.BankAccountdataService.BankAccountdataService;
import dataService.BillManagementdataService.BillManagementdataService;
import dataService.CarAndDriverdataService.CarAndDriverdataService;
import dataService.CommoditydataService.CommoditydataService;
import dataService.CostBenefitdataService.CostBenefitdataService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import dataService.ReceiptsdataService.ReceiptsdataService;
import dataService.SalesdataService.SalesdataService;
import dataService.StrategydataService.StrategydataService;
import dataService.UserdataService.UserdataService;
import dataService.VoucherSearchdataService.VoucherSearchdataService;
import dataService.WareHousedataService.WareHousedataService;

public interface DataFactoryService extends Remote {
	
	ApprovaldataService getApprovaldataService();
	BankAccountdataService getBankAccountdataService(); 
	BillManagementdataService getBillManagementdataService();
	CarAndDriverdataService getCarAndDriverdataService();
	CommoditydataService getCommoditydataService();
	CostBenefitdataService getCostBenefitdataService();
=======

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
public interface DataFactoryService extends Remote {	
>>>>>>> origin/master
	LogisticsDataService getLogisticsDataService();
	ReceiptsdataService getReceiptsdataService();
	SalesdataService getSalesdataService();
	StrategydataService getStrategydaateService();
	UserdataService getUserdataService();
	VoucherSearchdataService getVoucherSearchdataService();
	WareHousedataService getWareHousedataService();
	
}
<<<<<<< HEAD

=======
>>>>>>> origin/master
