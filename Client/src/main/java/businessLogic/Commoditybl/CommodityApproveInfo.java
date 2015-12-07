package businessLogic.Commoditybl;

import java.util.ArrayList;

import vo.receipts.StorageInReceiptVO;
import vo.receipts.StorageOutReceiptVO;
import dataService.ResultMessage;

public interface CommodityApproveInfo {
    public ArrayList<StorageInReceiptVO> viewAllStorageInReceiptSubmitted();
	
	public ResultMessage approveEnterReceipt(String id);
	
	public ArrayList<StorageInReceiptVO> viewAllStorageInReceipt();
	
	public ArrayList<StorageOutReceiptVO> viewAllStorageOutReceiptSubmitted();
	
	public ResultMessage approveExitReceipt(String id);
	
	public ArrayList<StorageOutReceiptVO> viewAllStorageOutReceipt();

}
