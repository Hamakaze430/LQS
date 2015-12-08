package data.Strategydata;

import java.util.ArrayList;

import po.receipts.ArrivalReceiptPO;
import Miscellaneous.ResultMessage;

public interface HallArrivalDAO {
	public ResultMessage insert(ArrivalReceiptPO po);
	public ResultMessage delete(String id);
	public ArrivalReceiptPO find (String id);
	public ArrayList<ArrivalReceiptPO> getAll();
	public ArrayList<ArrivalReceiptPO> showAll();
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list);
	public void flush();
}
