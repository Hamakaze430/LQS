package dataService.DataFactoryService;

import dataService.BankAccountdataService.BankAccountdataService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import init.RMIHelper;

public class DataFactory implements DataFactoryService {
	private LogisticsDataService logisticsData;
	
	public LogisticsDataService getLogisticsDataService() {
		logisticsData = RMIHelper.getLogisticsData();
		return logisticsData;
	}

	public BankAccountdataService getBankAccountData() {
		// TODO Auto-generated method stub
		return null;
	}

}
