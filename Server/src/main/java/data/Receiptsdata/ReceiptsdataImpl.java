package data.Receiptsdata;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import po.ReceiptPO;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;
import dataService.ReceiptsdataService.ReceiptsdataService;

public class ReceiptsdataImpl extends UnicastRemoteObject implements ReceiptsdataService{

	public ReceiptsdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getReceipt(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastId(String foreId) throws RemoteException {
		
		return "00001";
	}

	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date) throws RemoteException {
		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		ReceiptPO temp;
		Date tmpDate;
		try {
			Date comp=df.parse(date);
			try {
				ObjectInputStream in=new ObjectInputStream(
						new FileInputStream("src/main/java/ser/receipts.ser"));
				while((temp=(ReceiptPO)in.readObject())!=null){
					tmpDate=df.parse(temp.getCreateDate());
					if(tmpDate.before(comp)||tmpDate.equals(comp)){
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
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<PaymentPO> getPaymentBeforeDate(String date) throws RemoteException{
		ArrayList<PaymentPO> list=new ArrayList<PaymentPO>();
		ArrayList<ReceiptPO> receipts=this.getReceiptBeforeDate(date);
		for(int i=0;i<receipts.size();i++){
			if(receipts.get(i).getClass().equals(PaymentPO.class)){
				list.add((PaymentPO)receipts.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<IncomePO> getIncomeBeforeDate(String date) throws RemoteException{
		ArrayList<IncomePO> list=new ArrayList<IncomePO>();
		ArrayList<ReceiptPO> receipts=this.getReceiptBeforeDate(date);
		for(int i=0;i<receipts.size();i++){
			if(receipts.get(i).getClass().equals(IncomePO.class)){
				list.add((IncomePO)receipts.get(i));
			}
		}
		return list;
	}

	public ReceiptPO getReceiptbyDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<ReceiptPO> getforSales(String start, String end) throws RemoteException{
		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		ReceiptPO temp;
		try {
			Date d1=df.parse(start);
			Date d2=df.parse(end);
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/receipts.ser"));
			while((temp=(ReceiptPO)in.readObject())!=null){
				Date tmpDate=df.parse(temp.getCreateDate());
				if(tmpDate.after(d1)&&tmpDate.before(d2)){
					list.add(temp);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	

}
