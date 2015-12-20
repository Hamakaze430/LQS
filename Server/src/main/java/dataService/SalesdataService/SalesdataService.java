package dataService.SalesdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.*;

public interface SalesdataService extends Remote{

	public void save(SalesPO sales) throws RemoteException;
	
	public SalesPO getSales(String start, String end) throws RemoteException;
	
	public boolean getReport(SalesPO sales) throws RemoteException;
}
