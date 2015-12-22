package data.CostBenefitdata;

import po.*;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import data.Receiptsdata.Calculator;
import data.Receiptsdata.ReceiptsdataImpl;
import data.ReportGenerator.ReportGenerator;
import dataService.CostBenefitdataService.CostBenefitdataService;

import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CostBenefitdataImpl extends UnicastRemoteObject implements CostBenefitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReceiptsdataImpl rdi=new ReceiptsdataImpl();
	
	public CostBenefitdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		/*
		 * generate mock receipts
		 * */
//		Test test=new Test();
//		test.saveMockReceipts();
	}

	/**
	 * 
	 */

	public CostBenefitPO getCostBenefitPO(String date) throws RemoteException {
		// TODO Auto-generated method stub
		CostBenefitPO cb=new CostBenefitPO();
		//cb.setLists(date);
		ArrayList<PaymentPO> temp_pay=rdi.getPaymentBeforeDate(date);
		ArrayList<IncomePO> temp_in=rdi.getIncomeBeforeDate(date);
		cb.setLists(temp_pay, temp_in);
		
		Calculator cal=new Calculator(cb.getPaymentList(), cb.getIncomeList());
		cb.setTotalIncome(cal.getIncome());
		cb.setTotalPayment(cal.getPayment());
		cb.setTotalProfit(cal.getProfit());
	
//		System.out.println("got new cbPO");
		return cb;
	}

	public boolean getReport(CostBenefitPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ReportGenerator gen = new ReportGenerator();
		return gen.createCostBenefitReport(po);
	}

}
