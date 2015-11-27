package dataService.BillManagementdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BankAccountVO;
import vo.CarVO;
import vo.CommodityVO;
import vo.UserVO;

public interface BillManagementdataService extends Remote{
	
	public ArrayList<UserVO> getWorkers();

    public ArrayList<CarVO> getCars();

    public ArrayList<CommodityVO> getStorage();

    public ArrayList<BankAccountVO> getAccountInfo();
    
}
