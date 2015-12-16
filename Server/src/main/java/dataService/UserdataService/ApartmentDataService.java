package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Miscellaneous.Place;
import po.HallPO;

public interface ApartmentDataService extends Remote {
	public List<HallPO> findAll() throws RemoteException;

	public boolean insert(HallPO po, String type) throws RemoteException;
	
	public int getNum(String s, String place) throws RemoteException;
	
	public boolean delete(HallPO po) throws RemoteException;
	
	public boolean update(HallPO po) throws RemoteException;
	
	public HallPO find(String known, String hall) throws RemoteException;
	
	public List<HallPO> findAll(String known, String hallInfo) throws RemoteException;
}
