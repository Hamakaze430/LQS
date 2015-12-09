package dataService.CommoditydataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.ResultMessage;
import po.ComGoodsPO;
import po.ComInfoPO;
import po.ComZonePO;
import po.receipts.StorageInReceiptPO;
import po.receipts.StorageOutReceiptPO;

public interface CommoditydataService extends Remote{
	
	
	public ArrayList<ComGoodsPO> getComGoods(String comID) throws RemoteException;
	public String getLocation(String comID) throws RemoteException;
	public ComZonePO getZone(String comID) throws RemoteException;
	public ResultMessage modifyZone(String comID, int[] space) throws RemoteException;
	public ResultMessage initZone(String comID) throws RemoteException;
	
	
	public void addGoods(String comID, StorageInReceiptPO po) throws RemoteException;
	public void removeGoods(String comID, StorageOutReceiptPO po) throws RemoteException;
	public ComGoodsPO getGoods(String comID, String orderID) throws RemoteException;
	public void moveGoods(String comID, Object data[][]);

	
	public void addCommodity(String location, int totalSpace) throws RemoteException;
	public void removeCommodity(String comID) throws RemoteException;
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException;
	
	
	public void addStorageInReceipt(StorageInReceiptPO po) throws RemoteException;
	public String getNextStorageInID(String comID) throws RemoteException;
	public ArrayList<StorageInReceiptPO> getStorageInReceipt(String comID) throws RemoteException;
	public ArrayList<StorageInReceiptPO> getStorageInReceipt() throws RemoteException;
	public ArrayList<StorageInReceiptPO> getSummitStorageIn() throws RemoteException;
	public ResultMessage approveStorageInReceipt(String id) throws RemoteException;
	//public void approveStorageInReceipt(ArrayList<StorageInReceiptPO> list) throws RemoteException;
	//public void modifyStorageInReceipt(String id, StorageInReceiptPO po) throws RemoteException;
	
	
	public void addStorageOutReceipt(StorageOutReceiptPO po) throws RemoteException;
	public String getNextStorageOutID(String comID) throws RemoteException;
	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt(String comID) throws RemoteException;
	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt() throws RemoteException;
	public ArrayList<StorageOutReceiptPO> getSummitStorageOut() throws RemoteException;
	public ResultMessage approveStorageOutReceipt(String id) throws RemoteException;
	//public void approveStorageOutReceipt(ArrayList<StorageOutReceiptPO> list) throws RemoteException;
	//public void modifyStorageOutReceipt(String id, StorageOutReceiptPO po) throws RemoteException;

	
	
}

