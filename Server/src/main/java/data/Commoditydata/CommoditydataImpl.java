package data.Commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Miscellaneous.ResultMessage;
import po.ComGoodsPO;
import po.ComInfoPO;
import po.ComZonePO;
import po.CommodityPO;
import po.receipts.StorageInReceiptPO;
import po.receipts.StorageOutReceiptPO;
import dataService.CommoditydataService.CommoditydataService;

public class CommoditydataImpl extends UnicastRemoteObject implements CommoditydataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5960764122860351292L;
	
    StorageInReceiptDAO storageinDAO;
	StorageOutReceiptDAO storageoutDAO;
	ComInfoDAO comInfoDAO;

	public CommoditydataImpl() throws RemoteException{
		
	}

	
	public ArrayList<ComGoodsPO> getComGoods(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDAO.find(comID);
		return po.getComGoodsList();
	}

	
	public String getLocation(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDAO.find(comID);
		return po.getLocation();
	}

	
	public ComZonePO getZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDAO.find(comID);
		return po.getZone();
	}

	
	public ResultMessage modifyZone(String comID, int[] space)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ComInfoPO com = comInfoDAO.find(comID);
		ComZonePO po = com.getZone();
		boolean[] planeSpace = po.getIsEmptyPlane();
		boolean[] trainSpace = po.getIsEmptyTrain();
		boolean[] carSpace = po.getIsEmptyCar();
		boolean[] temSpace = po.getIsEmptyTem();
		for(int i=planeSpace.length;i<space[0];i++)
			if(planeSpace[i]==false)
				return ResultMessage.FAILURE;
		for(int i=trainSpace.length;i<space[1];i++)
			if(trainSpace[i]==false)
				return ResultMessage.FAILURE;
		for(int i=carSpace.length;i<space[2];i++)
			if(carSpace[i]==false)
				return ResultMessage.FAILURE;
		for(int i=temSpace.length;i<space[3];i++)
			if(temSpace[i]==false)
				return ResultMessage.FAILURE;
		
		boolean[] newPlane = new boolean[space[0]];
		boolean[] newTrain = new boolean[space[1]];
		boolean[] newCar = new boolean[space[2]];
		boolean[] newTem = new boolean[space[3]];
		
		for(int i=0;i<space[0];i++)
			newPlane[i] = planeSpace[i];
		for(int i=0;i<space[0];i++)
			newTrain[i] = trainSpace[i];
		for(int i=0;i<space[0];i++)
			newCar[i] = carSpace[i];
		for(int i=0;i<space[0];i++)
			newTem[i] = temSpace[i];
		
		po.setIsEmptyPlane(newPlane);
		po.setIsEmptyTrain(newTrain);
		po.setIsEmptyCar(newCar);
		po.setIsEmptyTem(newTem);
		
		comInfoDAO.modify(comID, com);
		
		return ResultMessage.SUCCESS;
	}


	
	public ResultMessage initZone(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		ComZonePO po = comInfoDAO.find(comID).getZone();
		
		return modifyZone(comID,po.getSpace());
	}

	
	public void addGoods(String comID, StorageInReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		comInfoDAO.addGoods(comID, po.getGoods());
	}

	
	public void removeGoods(String comID, StorageOutReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		comInfoDAO.removeGoods(comID, po.getGoods());
	}

	
	public ComGoodsPO getGoods(String comID, String orderID)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<ComGoodsPO> list = comInfoDAO.find(comID).getComGoodsList();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getId().equals(orderID))
				return list.get(i);
		return null;
	}

	
	public void moveGoods(String comID, Object[][] data) {
		// TODO Auto-generated method stub
		ComInfoPO po = comInfoDAO.find(comID);
		ComZonePO zone = po.getZone();
		ArrayList<ComGoodsPO> goods = po.getComGoodsList();
		
		 int shelfPerLine = zone.getShelfPerLine();
		 int cellPerShelf = zone.getCellPerShelf();
		 
		 boolean isEmptyPlane[] = zone.getIsEmptyPlane();
		 boolean isEmptyTrain[] = zone.getIsEmptyTrain();
		 boolean isEmptyCar[] = zone.getIsEmptyCar();
		 boolean isEmptyTem[] = zone.getIsEmptyTem();
			
		 for(int i=0;i<isEmptyPlane.length;i++)
				isEmptyPlane[i] = true;
		 for(int i=0;i<isEmptyTrain.length;i++)
				isEmptyTrain[i] = true;
		 for(int i=0;i<isEmptyCar.length;i++)
				isEmptyCar[i] = true;
		 for(int i=0;i<isEmptyTem.length;i++)
				isEmptyTem[i] = true;
		
		for(int i=0;i<data.length;i++){
			int index = (Integer.parseInt((String) data[i][2])-1)*shelfPerLine*cellPerShelf+(Integer.parseInt((String) data[i][3])-1)*cellPerShelf+(Integer.parseInt((String) data[i][4])-1);
			goods.get(i).setLine(Integer.parseInt((String) data[i][2]));
			goods.get(i).setShelf(Integer.parseInt((String) data[i][3]));
			goods.get(i).setCell(Integer.parseInt((String) data[i][4]));
			String type = (String) data[i][1];
			if(type.equals("航运区"))
				isEmptyPlane[index] = false;
			if(type.equals("铁运区"))
				isEmptyTrain[index] = false;
			if(type.equals("汽运区"))
				isEmptyCar[index] = false;
			if(type.equals("机动区"))
				isEmptyTem[index] = false;
		}
		
		zone.setIsEmptyPlane(isEmptyPlane);
		zone.setIsEmptyTrain(isEmptyTrain);
		zone.setIsEmptyCar(isEmptyCar);
		zone.setIsEmptyTem(isEmptyTem);
		
		comInfoDAO.modify(comID, po);
		
	}

	
	public void addCommodity(String location, int totalSpace)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		ComInfoPO po = new ComInfoPO(comInfoDAO.nextID(),location,totalSpace);
		comInfoDAO.add(po);
		
	}

	
	public void removeCommodity(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		comInfoDAO.remove(comID);
		
	}

	
	public ArrayList<ComInfoPO> getCommodity() throws RemoteException {
		// TODO Auto-generated method stub
		return comInfoDAO.getAll();
	}

	
	public void addStorageInReceipt(StorageInReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		storageinDAO.add(po);
		
	}

	
	public String getNextStorageInID(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageinDAO.nextID(comID);
	}

	
	public ArrayList<StorageInReceiptPO> getStorageInReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageinDAO.showAllReceipt(comID);
	}

	
	public ArrayList<StorageInReceiptPO> getStorageInReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageinDAO.showAllReceipt();
	}

	
	public ArrayList<StorageInReceiptPO> getSummitStorageIn() throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageinDAO.showAllSummit();
	}

	
	public ResultMessage approveStorageInReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageinDAO.approve(id);
	}

	
	public void addStorageOutReceipt(StorageOutReceiptPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		storageoutDAO.add(po);
		
	}

	
	public String getNextStorageOutID(String comID) throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageoutDAO.nextID(comID);
	}

	
	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt(String comID)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageoutDAO.showAllReceipt(comID);
	}

	
	public ArrayList<StorageOutReceiptPO> getStorageOutReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageoutDAO.showAllReceipt();
	}

	
	public ArrayList<StorageOutReceiptPO> getSummitStorageOut() throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageoutDAO.showAllSummit();
	}

	
	public ResultMessage approveStorageOutReceipt(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return storageoutDAO.approve(id);
	}


}
