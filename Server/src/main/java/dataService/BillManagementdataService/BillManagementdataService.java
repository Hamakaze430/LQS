package dataService.BillManagementdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;


public interface BillManagementdataService {

	public BillManagementPO create();
	
	public ArrayList<BillManagementPO> getBillManagementPO(String date);
	
	public void save(BillManagementPO bm);
	
	public void getReport(BillManagementPO po);
}
