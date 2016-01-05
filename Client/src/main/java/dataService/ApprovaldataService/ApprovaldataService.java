package dataService.ApprovaldataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ApprovalPO;

public interface ApprovaldataService extends Remote{

	boolean insert(ApprovalPO po);
	public List<ApprovalPO> findAll();
	public boolean delete(List<Long> poList);
	public boolean delete(long id);
<<<<<<< HEAD
=======

>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
}
