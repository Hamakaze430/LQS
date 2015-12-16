package dataService.StrategydataService.StationdataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StationPO;
import po.receipts.ArriveReceiptPO;
import po.receipts.TransferReceiptPO;
import dataService.ResultMessage;

public interface StationdataService {
    public String getLocation(String id) throws RemoteException;
	
	public ResultMessage addStation(String id, String location) throws RemoteException;
	public ResultMessage removeStation(String id) throws RemoteException;
	public ArrayList<StationPO> showStation() throws RemoteException;
	
	
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException;
	public String nextArriveID(String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException;
	public ResultMessage approveArriveReceipt(String id) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getApproveArrive(String comID) throws RemoteException;
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException;
	//public void modifyArriveReceipt(String id, ArriveReceiptPO po) throws RemoteException;
	
	
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException;
	public String nextTransferID(String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getTransferReceipt() throws RemoteException;
	public ResultMessage approveTransferReceipt(String id) throws RemoteException;
	public ArrayList<TransferReceiptPO> getApproveTransfer(String comID) throws RemoteException;
	public ArrayList<TransferReceiptPO> getSummitTransfer() throws RemoteException;
	//public void modifyTransferReceipt(String id, TransferReceiptPO po) throws RemoteException;
	
	public TransferReceiptPO getTransfer(String id) throws RemoteException;
	

}
