package data.Strategydata;

import java.util.ArrayList;

import po.HallPO;
import Miscellaneous.ResultMessage;

public interface HallDAO {
	
	public ResultMessage insert(HallPO hallPo);
	public ResultMessage delete(String id);
	public ArrayList<HallPO> getAll();
	public ArrayList<HallPO> showAll();
	public void flush();
}
