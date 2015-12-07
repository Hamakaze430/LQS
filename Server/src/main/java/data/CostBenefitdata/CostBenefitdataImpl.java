package data.CostBenefitdata;

import po.*;
import data.Receiptsdata.ReceiptsdataImpl;
import data.ReportGenerator.ReportGenerator;
import dataService.CostBenefitdataService.CostBenefitdataService;

import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CostBenefitdataImpl implements CostBenefitdataService{

	/**
	 * 
	 */

	public CostBenefitPO getCostBenefitPO(String date) {
		// TODO Auto-generated method stub
		CostBenefitPO cb=new CostBenefitPO();
		cb.setLists(date);
		cb.setTotal();
		return cb;
	}

	@Override
	public void getReport(CostBenefitPO po) {
		// TODO Auto-generated method stub
		ReportGenerator gen = new ReportGenerator();
		gen.createCostBenefitReport(po);
	}

}
