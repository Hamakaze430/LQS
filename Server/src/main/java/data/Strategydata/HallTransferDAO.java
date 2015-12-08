package data.Strategydata;

import java.util.ArrayList;

import po.receipts.HallTransferReceiptPO;
import Miscellaneous.ResultMessage;

public interface HallTransferDAO {
	public ResultMessage insert(HallTransferReceiptPO po);
	public ResultMessage delete(String id);
	public HallTransferReceiptPO find(String id);
	public ArrayList<HallTransferReceiptPO> getAll();
	public ArrayList<HallTransferReceiptPO> showAll();
	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list);
	public void flush();
}