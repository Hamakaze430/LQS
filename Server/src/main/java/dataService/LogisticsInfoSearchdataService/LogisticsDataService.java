package dataService.LogisticsInfoSearchdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LogisticsPO;

public interface LogisticsDataService extends Remote {
	public LogisticsPO find(String id)throws RemoteException;
	public boolean insert(LogisticsPO po)throws RemoteException;
}
