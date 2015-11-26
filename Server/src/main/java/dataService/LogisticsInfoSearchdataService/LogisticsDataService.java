package dataService.LogisticsInfoSearchdataService;

import po.LogisticsPO;

public interface LogisticsDataService {
	public LogisticsPO find(String id);
	public boolean insert(LogisticsPO po);
}
