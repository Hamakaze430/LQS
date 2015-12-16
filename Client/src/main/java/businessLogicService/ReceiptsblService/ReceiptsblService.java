package businessLogicService.ReceiptsblService;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.FormType;
import vo.CarVO;

public interface ReceiptsblService {
	
	public String getLastId(String foreID);

	public ArrayList<String> getCarInfo(String hallId);
	public String getHallId();
	public String getFormName(FormType type);
	public String getCurrentTime();
	public String changeDateFormat(String date);

	public String getName();

	public String getCreater();

	public List<String> getHallNameListByAddress(String string);

	public String getHallPlace();

	public String getHallName();

	
}
