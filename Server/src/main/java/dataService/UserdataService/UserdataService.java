package dataService.UserdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.*;

public interface UserdataService extends Remote {

	public UserPO getCurrentUser() throws RemoteException;
	
	public boolean addUser (UserPO user) throws RemoteException;

	public List<UserPO> getAllUsers() throws RemoteException;
	
	public boolean deleteUser(UserPO po) throws RemoteException;
	
	public boolean updateUser(UserPO po) throws RemoteException;
	
	public int getCount(String id) throws RemoteException;
	
	public UserPO find(String known, String info) throws RemoteException;
}
