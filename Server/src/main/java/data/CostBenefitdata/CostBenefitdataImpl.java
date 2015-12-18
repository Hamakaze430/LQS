package data.CostBenefitdata;

import po.*;
import data.Receiptsdata.ReceiptsdataImpl;
import data.ReportGenerator.ReportGenerator;
import dataService.CostBenefitdataService.CostBenefitdataService;

import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CostBenefitdataImpl extends UnicastRemoteObject implements CostBenefitdataService{

	public CostBenefitdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Created new CBDataImpl");
		Test test=new Test();
		test.saveMockReceipts();
	}

	/**
	 * 
	 */

	public CostBenefitPO getCostBenefitPO(String date) throws RemoteException {
		// TODO Auto-generated method stub
		CostBenefitPO cb=new CostBenefitPO();
		cb.setLists(date);
		cb.setTotal();
		System.out.println("got new cbPO");
		return cb;
	}

	public void getReport(CostBenefitPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ReportGenerator gen = new ReportGenerator();
		gen.createCostBenefitReport(po);
	}

}
