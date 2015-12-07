package dataService.CommoditydataService;

import java.rmi.Remote;
import java.util.ArrayList;

import dataService.ResultMessage;
import po.ComGoodsPO;
import po.ComZonePO;
import po.receipts.StorageInReceiptPO;
import po.receipts.StorageOutReceiptPO;

public interface CommoditydataService extends Remote{

    public String get();

	public String getLocation(String comID);

	public ComZonePO getZone(String comID);

	public Object getNextStorageInID(String comID);

	public void addStorageInReceipt(StorageInReceiptPO po);

	public String getNextStorageOutID(String comID);

	public ComGoodsPO getGoods(String comID, String id);

	public void addStorageOutReceipt(StorageOutReceiptPO po);

	public ArrayList<ComGoodsPO> getComGoods(String comID);

	public ArrayList<StorageInReceiptPO> getStorageInReceipt(String comID);

	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt(String comID);

	public ResultMessage modifyZone(String comID, int[] space);

	public ResultMessage initZone(String comID);

	public void moveGoods(String comID, Object[][] data);

	public ArrayList<StorageInReceiptPO> getSummitStorageIn();

	public ResultMessage approveStorageInReceipt(String id);

	public ArrayList<StorageInReceiptPO> getStorageInReceipt();

	public ResultMessage approveStorageOutReceipt(String id);

	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt();

	public ArrayList<StorageOutReceiptPO> getSummitStorageOut();
}
