package data.Approvaldata;

import java.rmi.RemoteException;
import java.util.List;

import po.ApprovalPO;
import dataService.ApprovaldataService.ApprovaldataService;

public class Approvaldata implements ApprovaldataService {

	public boolean insert(ApprovalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ApprovalPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(List<ApprovalPO> poList) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(ApprovalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
