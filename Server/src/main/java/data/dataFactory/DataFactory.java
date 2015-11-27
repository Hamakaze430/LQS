package data.DataFactory;

import data.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.io.*;

import Miscellaneous.Date;
import po.*;
import dataService.DataFactoryService.DataFactoryService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService{

	public DataFactory() throws RemoteException {
		super();
	}

	public UserPO getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillManagementPO getBM() {
		// TODO Auto-generated method stub
		return null;
	}

	public SalesPO getSales() {
		// TODO Auto-generated method stub
		return null;
	}

	public CostBenefitPO getCB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getName(){
		// TODO Auto-generated method stub
		return null;
	}

	public CarPO getCar() {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverPO getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public CommodityPO getCommodity() {
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountPO getBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	public BillManagementPO getBM(String date) {
		// TODO Auto-generated method stub
		return null;
	}

//	public void saveBMPO(BillManagementPO bm) {
//		// TODO Auto-generated method stub
//		try {
//			ObjectOutputStream out=new ObjectOutputStream(
//					new FileOutputStream("/Server/src/main/java/txt/bill.txt"));
//			out.writeObject(bm);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public ReceiptPO getReceiptbyDate(String date) {
		
		return null;
	}

	public void writeLog(String log) {
		try {
			FileWriter fw=new FileWriter("/Server/src/main/java/txt/log.txt");
			fw.write(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
