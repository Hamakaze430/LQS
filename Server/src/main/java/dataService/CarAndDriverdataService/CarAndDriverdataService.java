package dataService.CarAndDriverdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CarAndDriverPO;

public interface CarAndDriverdataService extends Remote {
	public boolean insert(String type, CarAndDriverPO po) throws RemoteException;
	public List<CarAndDriverPO> findAll(String type, String know, String info) throws RemoteException;
	public int getCount(String type, String foreId) throws RemoteException;
	public boolean find(String type, String known) throws RemoteException;
}
