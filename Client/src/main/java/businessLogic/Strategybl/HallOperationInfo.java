package businessLogic.Strategybl;

import java.util.ArrayList;

import vo.HallVO;
import dataService.ResultMessage;

public interface HallOperationInfo {	
	public ArrayList<HallVO> showHall();
	
    public ResultMessage addHall(String id,String name);
	
	public ResultMessage removeHall(String id);
}
