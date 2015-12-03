package businessLogic.LogisticsInfoSearchbl;


import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import dataService.DataFactoryService.DataFactoryService;
<<<<<<< HEAD
=======
import init.Client;
>>>>>>> origin/master
import init.RMIHelper;
import po.LogisticsPO;
import vo.LogisticsVO;

public class LogisticsInfoSearchbl implements LogisticsInfoSearchblService {
	private DataFactoryService dataFactory;
	
	public LogisticsInfoSearchbl(){
		dataFactory = Client.dataFactory;
	}
	public LogisticsVO search(String id) {		
		LogisticsPO po = dataFactory.getLogisticsDataService().find(id);
		if (po == null) return null;
		LogisticsVO vo = new LogisticsVO(po.getId(), po.getState());
		return vo;
	}

}
