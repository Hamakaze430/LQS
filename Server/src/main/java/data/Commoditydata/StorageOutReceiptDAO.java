package data.Commoditydata;

import java.util.ArrayList;

import Miscellaneous.ResultMessage;
import po.receipts.StorageOutReceiptPO;

public interface StorageOutReceiptDAO {

	public void add(StorageOutReceiptPO po);
	public ArrayList<StorageOutReceiptPO> showAllReceipt();
	public ArrayList<StorageOutReceiptPO> showAllReceipt(String comID);
	public ArrayList<StorageOutReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	public String nextID(String comID);
	
}
