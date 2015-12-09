package data.Commoditydata;

import java.util.ArrayList;

import Miscellaneous.ResultMessage;
import po.receipts.StorageInReceiptPO;

public interface StorageInReceiptDAO {

	public void add(StorageInReceiptPO po);
	public ArrayList<StorageInReceiptPO> showAllReceipt();
	public ArrayList<StorageInReceiptPO> showAllReceipt(String comID);
	public ArrayList<StorageInReceiptPO> showAllSummit();
	public ResultMessage approve(String id);
	public String nextID(String comID);
	
}
