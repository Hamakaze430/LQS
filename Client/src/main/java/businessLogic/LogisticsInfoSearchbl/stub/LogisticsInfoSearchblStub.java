package businessLogic.LogisticsInfoSearchbl.stub;

import java.util.ArrayList;

import Miscellaneous.LogisticsState;
import businessLogicService.LogisticsInfoSearchblService.LogisticsInfoSearchblService;
import vo.LogisticsVO;
import vo.ReceiptVO;

public class LogisticsInfoSearchblStub implements LogisticsInfoSearchblService {

	public LogisticsVO search(String id) {
		// TODO Auto-generated method stub
		if (id.equals("1234567890")){
			ArrayList<String> list = new ArrayList<String>();
			list.add(LogisticsState.快递员已收件.toString());
			return null;
		}
		return null;
	}

	public void newLogisticsInfo(ReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void addState(ReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

}
