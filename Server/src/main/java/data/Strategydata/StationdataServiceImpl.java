package data.Strategydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StationPO;
import po.receipts.ArriveReceiptPO;
import po.receipts.TransferReceiptPO;
import Miscellaneous.ResultMessage;
import dataService.StrategydataService.StationdataService.StationdataService;

public class StationdataServiceImpl implements StationdataService{

	
	public String getLocation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage addStation(String id, String location)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage removeStation(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<StationPO> showStation() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addArriveReceipt(ArriveReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public String nextArriveID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<ArriveReceiptPO> getArriveReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage approveArriveReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<ArriveReceiptPO> getApproveArrive(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<ArriveReceiptPO> getSummitArrive() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void addTransferReceipt(TransferReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public String nextTransferID(String stationID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<TransferReceiptPO> getTransferReceipt()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ResultMessage approveTransferReceipt(String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<TransferReceiptPO> getApproveTransfer(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<TransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TransferReceiptPO getTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
