package dataService.LogisticsInfoSearchdataService;

import java.rmi.Remote;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote {
	public LogisticsPO find(String id) ;
	public boolean insert(LogisticsPO po);
}
