package businessLogicService.ReceiptsblService;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.FormType;
import vo.CarVO;
import vo.ReceiptVO;
import vo.UserVO;

public interface ReceiptsblService {
	
	public String getLastId(String foreID);
	public String getHallId();
	public String getFormName(FormType type);
	public String getCurrentTime();
	public String changeDateFormat(String date);
	public String getName();
	public String getCreater();
	public List<String> getHallNameListByAddress(String string);
	public String getHallPlace();
	public String getHallName();

	public boolean addReceipt(ReceiptVO vo);

	public boolean findCarAndDriver(String type, String known);

	public UserVO findUser(String userName);

	public boolean findLogistics(String s);

	public double getLoadingCost();

	

	
}
