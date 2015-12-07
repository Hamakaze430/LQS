package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.AuthorityPO;

public interface AuthoritiesSettingDataService extends Remote {
	public List<String> getList(String identity) throws RemoteException;
	public boolean save(AuthorityPO po) throws RemoteException;
}
