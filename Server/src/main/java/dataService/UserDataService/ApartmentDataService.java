package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HallPO;

public interface ApartmentDataService extends Remote {
	public List<HallPO> findAll() throws RemoteException;

	public boolean insert(HallPO po) throws RemoteException;
	
	public int getHallNum(String s, Place place) throws RemoteException;
}
