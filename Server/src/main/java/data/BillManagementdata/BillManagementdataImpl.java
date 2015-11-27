package data.BillManagementdata;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.RemoteException;

import po.*;
import data.DataFactory.DataFactory;
import dataService.BillManagementdataService.BillManagementdataService;

public class BillManagementdataImpl extends UnicastRemoteObject implements BillManagementdataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillManagementdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillManagementPO create() {	//create a new bill
		// TODO Auto-generated method stub
		try {
			DataFactory df=new DataFactory();
			
			SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
			String date=fm.format(new Date());
			
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

	public ArrayList<BillManagementPO> getBillManagementPO(String date) {
		// TODO Auto-generated method stub
		ArrayList<BillManagementPO> list=new ArrayList<BillManagementPO>();
		SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");
		BillManagementPO temp;
		try {
			Date comp = fm.parse(date);
			Date tmpDate;
			try {
				ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("/Server/src/main/java/txt/receipts.tx"));
				while((temp=(BillManagementPO)in.readObject())!=null){
					tmpDate=fm.parse(temp.getDate());
					if(tmpDate.equals(comp)){
						list.add(temp);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
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
