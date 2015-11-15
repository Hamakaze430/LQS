package businessLogic.LogisticsInfoSearchbl.stub;

import java.util.ArrayList;

import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import vo.LogisticsVO;
import vo.LogisticsState;

public class LogisticsInfoSearchblStub implements LogisticsInfoSearchblService {

	public LogisticsVO search(String id) {
		// TODO Auto-generated method stub
		if (id.equals("1234567890")){
			ArrayList<LogisticsState> list = new ArrayList<LogisticsState>();
			list.add(LogisticsState.快递员已收件);
			return new LogisticsVO("1234567890", list);
		}
		return null;
	}

}
