package businessLogic.BillManagementbl;

import java.util.*;

import po.*;
import businessLogicService.BillManagementblService.BillManagementblService;
import dataService.BillManagementdataService.BillManagementdataService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import init.RMIHelper;

public class BillManagement implements BillManagementblService{

	private BillManagementdataService bm;
	private DataFactoryService dataFactory;
	
	public BillManagement(){
		DataFactoryService dataFactory=Client.dataFactory;
		bm=dataFactory.getBillManagementdataService();
	}
	
	public BillManagementPO create() {
		return bm.create();
	}

	public void save(BillManagementPO po) {
		// TODO Auto-generated method stub
		bm.save(po);
	}

	public void check() {
		// TODO Auto-generated method stub
		
	}

	public void pass() {
		// TODO Auto-generated method stub
		
	}

	public void fail() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<BillManagementPO> getBillManagementPO(String date) {
		return bm.getBillManagementPO(date);
	}

	public void getReport(BillManagementPO po){
		bm.getReport(po);
	}

	public void getReport() {
		// TODO Auto-generated method stub
		
	}
	
}
