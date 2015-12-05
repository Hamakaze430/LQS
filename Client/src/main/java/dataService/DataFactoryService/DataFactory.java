package dataService.DataFactoryService;

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
import dataService.UserdataService.ApartmentDataService;
import dataService.UserdataService.UserdataService;
import dataService.VoucherSearchdataService.VoucherSearchdataService;
import dataService.WareHousedataService.WareHousedataService;
import init.RMIHelper;

public class DataFactory implements DataFactoryService {
	private static LogisticsDataService logisticsData;
	private static ApartmentDataService apartmentData;
	public LogisticsDataService getLogisticsDataService() {
		logisticsData = RMIHelper.getLogisticsData();
		return logisticsData;
	}

	public BankAccountdataService getBankAccountData() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApprovaldataService getApprovaldataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountdataService getBankAccountdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillManagementdataService getBillManagementdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public CarAndDriverdataService getCarAndDriverdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public CommoditydataService getCommoditydataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public CostBenefitdataService getCostBenefitdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiptsdataService getReceiptsdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public SalesdataService getSalesdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public StrategydataService getStrategydaateService() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserdataService getUserdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public VoucherSearchdataService getVoucherSearchdataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public WareHousedataService getWareHousedataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApartmentDataService getApartmentDataService() {
		apartmentData = RMIHelper.getApartmentData();
		return apartmentData;
	}

}
