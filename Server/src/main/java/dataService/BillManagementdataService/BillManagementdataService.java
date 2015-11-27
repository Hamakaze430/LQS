package dataService.BillManagementdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;


public interface BillManagementdataService extends Remote{

	public BillManagementPO create();
	
	public BillManagementPO getBillManagementPO(String date);
	
	public void save(BillManagementPO bm);
}
