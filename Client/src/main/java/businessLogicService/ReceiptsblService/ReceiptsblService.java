package businessLogicService.ReceiptsblService;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.FormType;
import vo.CarVO;
import vo.ReceiptVO;
import vo.UserVO;
import vo.receipts.SendVO;

public interface ReceiptsblService {
	
	public String getLastId(String foreID);
	public String getHallId();
	public String getCurrentTime();
	public String changeDateFormat(String date);
	public List<String> getHallNameListByAddress(String type,String string);
	public String getHallPlace();
	public String getHallName();
	public ReceiptVO getReceiptById(long receiptId);	
	public boolean addReceipt(ReceiptVO vo);
	public boolean findCarAndDriver(String type, String known);
	public UserVO findUser(String userName);
	public boolean findLogistics(String s);
	public double getLoadingCost(double v);
	public boolean findAccount(String s);
	public double getTransferCost(String string, String hallPlace, String endPlace);
	public ReceiptVO getLoadingOrTransferVO(String id);
	public String getHallName(String hallId);
	public double getSendCost(String expresstype, String start, String end, String weight, String volume);
	public boolean pass(long receiptId);
	public ReceiptVO getSendVO(String s);	
}
