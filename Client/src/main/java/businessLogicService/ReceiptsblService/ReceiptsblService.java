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
	public String getCurrentTime();
	public String changeDateFormat(String date);
	public List<String> getHallNameListByAddress(String string);
	public String getHallPlace();
	public String getHallName();
	public ReceiptVO getReceiptById(long receiptId);	
	public boolean addReceipt(ReceiptVO vo);
	public boolean findCarAndDriver(String type, String known);
	public UserVO findUser(String userName);
	public boolean findLogistics(String s);
	public double getLoadingCost();
	public boolean findAccount(String s);	
}
