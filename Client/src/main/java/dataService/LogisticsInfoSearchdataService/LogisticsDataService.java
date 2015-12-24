package dataService.LogisticsInfoSearchdataService;

import java.rmi.Remote;
import java.util.List;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote {
	public LogisticsPO find(String id) ;
	public boolean insert(LogisticsPO po);
	public boolean addState(List<String> order, String state);
	public boolean addState(String order, String state);
}
