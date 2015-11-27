package data.CostBenefitdata;

import po.*;
import dataService.CostBenefitdataService.CostBenefitdataService;
import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CostBenefitdataImpl extends UnicastRemoteObject implements CostBenefitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CostBenefitdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CostBenefitPO getCostBenefitPO(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ArrayList<ReceiptPO> getReceipts(String date){
		
		return null;
	}

}
