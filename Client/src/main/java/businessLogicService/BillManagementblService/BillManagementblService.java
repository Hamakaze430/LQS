package businessLogicService.BillManagementblService;

import vo.*;

import java.util.*;

import po.BillManagementPO;

public interface BillManagementblService{
	
    public BillManagementPO create();

    public void save(BillManagementPO po);
    
	public ArrayList<BillManagementPO> getBillManagementPO(String date);
	
	public void getReport();

    public void check();

    public void pass();

    public void fail();
}
