package dataService.StrategydataService.HalldataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HallPO;
import po.receipts.ArrivalReceiptPO;
import po.receipts.DeliverReceiptPO;
import po.receipts.HallTransferReceiptPO;
import dataService.ResultMessage;

public interface HalldataService {
	public ResultMessage addHall(HallPO po) throws RemoteException;
	public ResultMessage removeHall(String id) throws RemoteException;
	public ArrayList<HallPO> showHall() throws RemoteException;
	public void flushHalls() throws RemoteException;
	
	public String nextArrivalID(String hallID) throws RemoteException;
	public ResultMessage addHallArrival(ArrivalReceiptPO po)throws RemoteException;
	//public ResultMessage removeHallArrival(String id)throws RemoteException;
	public ArrivalReceiptPO findHallArrival(String id)throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)throws RemoteException;
	public void approveHallArrival(String id)throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getApproveArrival() throws RemoteException;
	public ArrayList<ArrivalReceiptPO> getSummitArrival() throws RemoteException;
	public void flushHallArrival() throws RemoteException;
	
	public String nextHallTransferID(String hallID) throws RemoteException;
	public ResultMessage addHallTransfer(HallTransferReceiptPO po)throws RemoteException;
	//public ResultMessage removeHallTransfer(String id)throws RemoteException;
	public HallTransferReceiptPO findHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer()throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)throws RemoteException;
	public void approveHallTransfer(String id)throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getApproveTransfer() throws RemoteException;
	public ArrayList<HallTransferReceiptPO> getSummitTransfer() throws RemoteException;
	public void flushHallTransfer()throws RemoteException;
	
	public String nextDeliverID(String hallID) throws RemoteException;
	public ResultMessage addHallDeliver(DeliverReceiptPO po) throws RemoteException;
	//public ResultMessage removeHallDeliver(String id)throws RemoteException;
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException;
	public ArrayList<DeliverReceiptPO> getAllHallDeliver()throws RemoteException;
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)throws RemoteException;
	public void approveHallDeliver(String id)throws RemoteException;
	public ArrayList<DeliverReceiptPO> getApproveDeliver() throws RemoteException;
	public ArrayList<DeliverReceiptPO> getSummitDeliver() throws RemoteException;
	public void flushHallDeliver()throws RemoteException;

}
