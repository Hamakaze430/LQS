package businessLogic.LogisticsInfoSearchbl;


import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import dataService.DataFactoryService.DataFactoryService;
<<<<<<< HEAD
=======
import init.RMIHelper;
import po.LogisticsPO;
>>>>>>> 5e45caaeb5ff63c2803006ab061c2dc3f5106fbc
import vo.LogisticsVO;

public class LogisticsInfoSearchbl implements LogisticsInfoSearchblService {
	private DataFactoryService dataFactory;
	
	public LogisticsInfoSearchbl(){
		dataFactory = RMIHelper.getDataFactory();
	}
	public LogisticsVO search(String id) {		
		LogisticsPO po = dataFactory.getLogisticsDataService().find(id);
		LogisticsVO vo = new LogisticsVO(po.getId(), po.getState());
		return vo;
	}

}
