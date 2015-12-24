package data.Salesdata;

import po.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.receipts.*;
import data.Receiptsdata.ReceiptsdataImpl;
import data.ReportGenerator.ReportGenerator;
import dataService.SalesdataService.SalesdataService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class SalesdataImpl extends UnicastRemoteObject implements SalesdataService{

	public SalesdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(SalesPO sales) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream out=new ObjectOutputStream(
					new FileOutputStream("/Server/src/main/java/ser/sales.ser"));
			out.writeObject(sales);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter fw=new FileWriter("src/main/java/ser/log.txt");
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm");
			String date=df.format(new Date());
			fw.write("User:"+" created new sales on "+date);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SalesPO getSales(String start, String end) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> payment=new ArrayList<PaymentPO>();
		ArrayList<IncomePO> income=new ArrayList<IncomePO>();
		ReceiptsdataImpl rdi;
		SalesPO sales=new SalesPO();
		try {
			rdi = new ReceiptsdataImpl();
			ArrayList<ReceiptPO> receipts=rdi.getforSales(start, end);
			System.out.println(receipts.size());
			for(int i=0;i<receipts.size();i++){
				if(receipts.get(i).getClass().equals(PaymentPO.class)){
					payment.add((PaymentPO)receipts.get(i));
				}
				else if(receipts.get(i).getClass().equals(IncomePO.class))
					income.add((IncomePO)receipts.get(i));
			}
			sales=new SalesPO(income, payment);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return sales;
	}

	public boolean getReport(SalesPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ReportGenerator gen=new ReportGenerator();
		return gen.createSalesReport(po);
	}

	
}
