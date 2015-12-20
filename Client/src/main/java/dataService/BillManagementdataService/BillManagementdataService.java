package dataService.BillManagementdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BillManagementPO;
import vo.BankAccountVO;
import vo.CarVO;
import vo.CommodityVO;
import vo.UserVO;

public interface BillManagementdataService extends Remote{
	
	public BillManagementPO create();
	
	public ArrayList<BillManagementPO> getBillManagementPO(String date);
	
	public void save(BillManagementPO bm);
    
	public boolean getReport(BillManagementPO po);

}
