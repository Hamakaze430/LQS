package dataService.UserdataService;

import java.rmi.Remote;

import po.UserPO;

public interface UserdataService extends Remote {
	
	public void add(UserPO po);
	
}
