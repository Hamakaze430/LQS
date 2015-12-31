package dataService.ApprovaldataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ApprovalPO;

public interface ApprovaldataService extends Remote{

	boolean insert(ApprovalPO po);
	public List<ApprovalPO> findAll();
<<<<<<< HEAD
	public boolean delete(List<ApprovalPO> poList);
	public boolean delete(ApprovalPO po);
=======
	public boolean delete(List<Long> poList);
	public boolean delete(long id);
>>>>>>> 1308c02f8ef1117282572129df3883e55e37571b

}
