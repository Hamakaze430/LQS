package data.BillManagementdata;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.rmi.RemoteException;

import po.*;
import data.DataFactory.DataFactory;
import dataService.BillManagementdataService.BillManagementdataService;

public class BillManagementdata extends UnicastRemoteObject implements BillManagementdataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillManagementdata() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillManagementPO create() {	//create a new bill
		// TODO Auto-generated method stub
		try {
			DataFactory df=new DataFactory();
			Calendar c=Calendar.getInstance();
	        int year=c.get(Calendar.YEAR);
	        int month=c.get(Calendar.MONTH);
	        int day=c.get(Calendar.DATE);
	        String date=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
	        String name=df.getName();
	        ArrayList<UserPO> user=new ArrayList<UserPO>();
	        user.add(df.getUser());
	        ArrayList<CarPO> car=new ArrayList<CarPO>();
	        car.add(df.getCar());
	        ArrayList<DriverPO> driver=new ArrayList<DriverPO>();
	        driver.add(df.getDriver());
	        ArrayList<CommodityPO> commo=new ArrayList<CommodityPO>();
	        commo.add(df.getCommodity());
	        ArrayList<BankAccountPO> baccount=new ArrayList<BankAccountPO>();
	        baccount.add(df.getBankAccount());
	        
			BillManagementPO bm=new BillManagementPO(date, name, user, car, driver, commo, baccount);
			return bm;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public BillManagementPO getBillManagementPO(String date) {
		// TODO Auto-generated method stub
		try {
			DataFactory df=new DataFactory();
			return df.getBM(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void save(BillManagementPO bill){
		try {
			ObjectOutputStream out=new ObjectOutputStream(
					new FileOutputStream("/Server/src/main/java/txt/bill.txt"));
			out.writeObject(bill);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
