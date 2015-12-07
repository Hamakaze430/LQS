package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;

public interface UserdataService extends Remote {
	
public UserPO getCurrentUser();
	
	public UserPO getUserbyID(String ID);
	
	public boolean addUser (UserPO user);

	public List<UserPO> getAllUsers();

	public boolean deleteUser(UserPO po);

	public boolean updateUser(UserPO po);
	
}
