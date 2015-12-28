package dataService.LogisticsInfoSearchdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote {
	public LogisticsPO find(String id)throws RemoteException;
	public boolean insert(LogisticsPO po)throws RemoteException;
	public boolean addState(List<String> order, String state) throws RemoteException;
	public boolean addState(String order, String state) throws RemoteException;
}
