package data.Receiptsdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import po.ReceiptPO;
import dataService.ReceiptsdataService.ReceiptsdataService;

public class Receiptsdata implements ReceiptsdataService{

	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date) {
		ArrayList<ReceiptPO> list=new ArrayList<ReceiptPO>();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		ReceiptPO temp;
		Date tmpDate;
		try {
			Date comp=df.parse(date);
			try {
				ObjectInputStream in=new ObjectInputStream(
						new FileInputStream("/Server/src/main/java/txt/receipts.tx"));
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

	public ReceiptPO getReceiptbyDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
