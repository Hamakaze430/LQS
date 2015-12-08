package businessLogicService.StrategyblService;

import java.util.ArrayList;

import vo.HallVO;
import dataService.ResultMessage;

public interface HallblService {
	public ResultMessage addHall(String name,String id, String location);;

	public ResultMessage removeHall(String id);

	public ArrayList<HallVO> showHall();


}
