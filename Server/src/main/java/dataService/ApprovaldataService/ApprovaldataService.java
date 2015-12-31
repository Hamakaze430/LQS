package dataService.ApprovaldataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ApprovalPO;

public interface ApprovaldataService extends Remote  {
	boolean insert(ApprovalPO po) throws RemoteException;
	public List<ApprovalPO> findAll() throws RemoteException;
<<<<<<< HEAD
	public boolean delete(List<ApprovalPO> poList) throws RemoteException;
	public boolean delete(ApprovalPO po) throws RemoteException;
=======
	public boolean delete(List<Long> poList) throws RemoteException;
	public boolean delete(long id) throws RemoteException;
>>>>>>> 1308c02f8ef1117282572129df3883e55e37571b
}
