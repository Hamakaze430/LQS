package businessLogicService.ReceiptsblService;

import java.util.ArrayList;

import Miscellaneous.FormType;
import vo.CarVO;

public interface ReceiptsblService {
	public String getLoadingId();

	public ArrayList<String> getCarInfo(String hallId);
	public String getHallId();
	public String getFormName(FormType type);
	public String getCurrentTime();
	public String changeDateFormat(String date);

	public String getName();

	public String getCreater();

	
}
