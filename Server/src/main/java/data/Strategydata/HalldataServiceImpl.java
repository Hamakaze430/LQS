package data.Strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.HallPO;
import po.receipts.ArrivalReceiptPO;
import po.receipts.DeliverReceiptPO;
import po.receipts.HallTransferReceiptPO;
import Miscellaneous.ResultMessage;
import dataService.StrategydataService.HalldataService.HalldataService;

public class HalldataServiceImpl extends UnicastRemoteObject implements HalldataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HallDAO hallDao;
	HallArrivalDAO hallArrivalDAO;
	HallTransferDAO hallTransferDAO;
	HallDeliverDAO hallDeliverDAO;

	public HalldataServiceImpl() throws RemoteException {

		super();
		// TODO Auto-generated constructor stub
		hallDao = new HallFileDAO("hall");
		hallArrivalDAO = new HallArrivalFileDAO("hallArrival");
		hallTransferDAO = new HallTransferFileDAO("hallTransfer");
		hallDeliverDAO = new HallDeliverFileDAO("hallDeliver");
		
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage addHall(HallPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.insert(po);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage removeHall(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.delete(id);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<HallPO> showHall() throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.showAll();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage addHallArrival(ArrivalReceiptPO po) throws RemoteException  {
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.insert(po);
	}

//	
//	public ResultMessage removeHallArrival(String id)throws RemoteException {
//		// TODO Auto-generated method stub
//		return this.hallArrivalDao.delete(id);
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrivalReceiptPO findHallArrival(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.find(id);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.showAll();
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list) throws RemoteException{
//		// TODO Auto-generated method stub
//		this.hallArrivalDao.approveArrivalReceipt(list);
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage addHallTransfer(HallTransferReceiptPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.insert(po);
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public ResultMessage removeHallTransfer(String id) throws RemoteException{
//		// TODO Auto-generated method stub
//		return this.hallTransferDao.delete(id);
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public HallTransferReceiptPO findHallTransfer(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.find(id);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.showAll();
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list) throws RemoteException{
//		// TODO Auto-generated method stub
//		this.hallTransferDao.approveTransferReceipt(list);;
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage addHallDeliver(DeliverReceiptPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.insert(po);
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public ResultMessage removeHallDeliver(String id)throws RemoteException {
//		// TODO Auto-generated method stub
//		return this.hallDeliverDao.delete(id);
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.find(id);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<DeliverReceiptPO> getAllHallDeliver() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.showAll();
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list)throws RemoteException {
//		// TODO Auto-generated method stub
//		this.hallDeliverDao.approveDeliverReceipt(list);
//	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void flushHalls() throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.flush();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void flushHallArrival() throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDAO.flush();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void flushHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		hallTransferDAO.flush();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void flushHallDeliver()throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDAO.flush();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public String nextArrivalID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void approveHallArrival(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<ArrivalReceiptPO> getApproveArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<ArrivalReceiptPO> getSummitArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public String nextHallTransferID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void approveHallTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<HallTransferReceiptPO> getApproveTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<HallTransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public String nextDeliverID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void approveHallDeliver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<DeliverReceiptPO> getApproveDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList<DeliverReceiptPO> getSummitDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD
//	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
//	public HallTransferReceiptPO getHallTransfer(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
