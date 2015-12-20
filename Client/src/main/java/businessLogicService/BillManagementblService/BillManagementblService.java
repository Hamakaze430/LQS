package businessLogicService.BillManagementblService;

import vo.*;

import java.util.*;

import po.BillManagementPO;

public interface BillManagementblService{
	
	/*
	 * 创建新账
	 * */
    public BillManagementPO create();

    /*
	 * 将PO保存至数据层
	 * 
	 * @param po，BillManagementPO
	 * */
    public void save(BillManagementPO po);
    
    /*
	 * 查找某一日期之前的账单
	 * 
	 * @param date，String型
	 * @return 
	 * */
	public ArrayList<BillManagementPO> getBillManagementPO(String date);
	
	public boolean getReport(BillManagementPO po);

    public void check();

    public void pass();

    public void fail();
}
