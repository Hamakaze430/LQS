package data.Receiptsdata;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import po.HallPO;
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

	public long getLastId(String foreId) throws RemoteException {
		File file = new File("src/main/java/ser/receiptsNum.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			List<String> list = new ArrayList<String>();
			while (s != null){
				list.add(s);
				s = br.readLine();
			}
			br.close();
			int num = 1;
			for (String str : list){
				if (str.indexOf(foreId) != -1){
					list.remove(str);
					num = Integer.valueOf(str.substring(foreId.length()+1)) + 1;
					break;
				}
			}
			String stri = foreId + " " +  num;
			list.add(stri);
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			for (String str : list){
				output.write(str + "\r\n");
			}
			output.close();
			return num-1;
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return -1;
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

	public boolean insert(ReceiptPO po) throws RemoteException {
		try {
			List<ReceiptPO>  list = findAll();
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/receipts.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(list);
			objectOut.close();
            return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	private List<ReceiptPO> findAll() {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/receipts.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  
	        List<ReceiptPO> list = (List<ReceiptPO>) objectIn.readObject();
	        return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return new ArrayList<ReceiptPO>();
	}

	public long addReceiptId() throws RemoteException {
		File file = new File("src/main/java/ser/receiptId.txt");
		try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(read);
			String s = br.readLine();
			long id = Long.valueOf(s);
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			output.write(String.valueOf(id+1) + "\r\n");
			output.close();
			return id;
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
		} catch (IOException e) {
			   e.printStackTrace();
		}
		return -1;
	}

	public ReceiptPO find(String known, String info) throws RemoteException {
		List<ReceiptPO>  list = findAll();
		if (known.equals("receiptId")){
			long id = Long.valueOf(info);
			for (ReceiptPO po : list){
				if (po.getReceiptId() == id){
					return po;
				}
			}
			return null;
		}
		return null;
	}	

}
