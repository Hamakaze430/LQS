package dataService.ApprovaldataService;

import java.rmi.Remote;
import java.util.List;

import po.ApprovalPO;

public interface ApprovaldataService extends Remote{

	boolean insert(ApprovalPO po);
	public List<ApprovalPO> findAll();
	public boolean delete(List<Long> poList);
	public boolean delete(long id);

}
