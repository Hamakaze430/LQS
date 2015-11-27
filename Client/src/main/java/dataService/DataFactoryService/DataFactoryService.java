package dataService.DataFactoryService;

import java.rmi.Remote;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;

public interface DataFactoryService extends Remote {
	
	LogisticsDataService getLogisticsDataService();
}

