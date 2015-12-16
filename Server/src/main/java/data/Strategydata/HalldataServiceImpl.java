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

	@Override
	public ResultMessage addHall(HallPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.insert(po);
	}

	@Override
	public ResultMessage removeHall(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.delete(id);
	}

	@Override
	public ArrayList<HallPO> showHall() throws RemoteException {
		// TODO Auto-generated method stub
		return hallDao.showAll();
	}

	@Override
	public ResultMessage addHallArrival(ArrivalReceiptPO po) throws RemoteException  {
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.insert(po);
	}

//	@Override
//	public ResultMessage removeHallArrival(String id)throws RemoteException {
//		// TODO Auto-generated method stub
//		return this.hallArrivalDao.delete(id);
//	}

	@Override
	public ArrivalReceiptPO findHallArrival(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.find(id);
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival()throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallArrivalDAO.showAll();
	}

//	@Override
//	public void approveHallArrival(ArrayList<ArrivalReceiptPO> list) throws RemoteException{
//		// TODO Auto-generated method stub
//		this.hallArrivalDao.approveArrivalReceipt(list);
//	}

	@Override
	public ResultMessage addHallTransfer(HallTransferReceiptPO po) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.insert(po);
	}

//	@Override
//	public ResultMessage removeHallTransfer(String id) throws RemoteException{
//		// TODO Auto-generated method stub
//		return this.hallTransferDao.delete(id);
//	}

	@Override
	public HallTransferReceiptPO findHallTransfer(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.find(id);
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallTransferDAO.showAll();
	}

//	@Override
//	public void approveHallTransfer(ArrayList<HallTransferReceiptPO> list) throws RemoteException{
//		// TODO Auto-generated method stub
//		this.hallTransferDao.approveTransferReceipt(list);;
//	}

	@Override
	public ResultMessage addHallDeliver(DeliverReceiptPO po)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.insert(po);
	}

//	@Override
//	public ResultMessage removeHallDeliver(String id)throws RemoteException {
//		// TODO Auto-generated method stub
//		return this.hallDeliverDao.delete(id);
//	}

	@Override
	public DeliverReceiptPO findHallDeliver(String id)throws RemoteException {
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.find(id);
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver() throws RemoteException{
		// TODO Auto-generated method stub
		return this.hallDeliverDAO.showAll();
	}

//	@Override
//	public void approveHallDeliver(ArrayList<DeliverReceiptPO> list)throws RemoteException {
//		// TODO Auto-generated method stub
//		this.hallDeliverDao.approveDeliverReceipt(list);
//	}

	@Override
	public void flushHalls() throws RemoteException {
		// TODO Auto-generated method stub
		hallDao.flush();
	}

	@Override
	public void flushHallArrival() throws RemoteException {
		// TODO Auto-generated method stub
		hallArrivalDAO.flush();
	}

	@Override
	public void flushHallTransfer() throws RemoteException{
		// TODO Auto-generated method stub
		hallTransferDAO.flush();
	}

	@Override
	public void flushHallDeliver()throws RemoteException {
		// TODO Auto-generated method stub
		hallDeliverDAO.flush();
	}

	@Override
	public String nextArrivalID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getAllHallArrival(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveHallArrival(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getApproveArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrivalReceiptPO> getSummitArrival()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nextHallTransferID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getAllHallTransfer(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveHallTransfer(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getApproveTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HallTransferReceiptPO> getSummitTransfer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nextDeliverID(String hallID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliverReceiptPO> getAllHallDeliver(String hallID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveHallDeliver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<DeliverReceiptPO> getApproveDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliverReceiptPO> getSummitDeliver()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public HallTransferReceiptPO getHallTransfer(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
