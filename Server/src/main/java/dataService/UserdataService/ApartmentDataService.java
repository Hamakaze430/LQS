package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Miscellaneous.Place;
import po.HallPO;

public interface ApartmentDataService extends Remote {
	public List<HallPO> findAll() throws RemoteException;

	public boolean insert(HallPO po) throws RemoteException;
	
	public int getNum(String s, Place place) throws RemoteException;
	
	public boolean addNum(String text, Place place) throws RemoteException;
	
	public boolean delete(HallPO po) throws RemoteException;
	
	public boolean update(HallPO po) throws RemoteException;
	
	public HallPO find(String known, String hall) throws RemoteException;
}
