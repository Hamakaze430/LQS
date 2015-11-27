package data.Receiptsdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;

import Miscellaneous.Date;
import po.ReceiptPO;
import data.DataFactory.DateHelper;
import dataService.ReceiptsdataService.ReceiptsdataService;

public class Receiptsdata implements ReceiptsdataService{

	public ReceiptPO getReceiptbyDate(String date) {
		DateHelper dh=new DateHelper();
		Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        String t=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        Date today=new Date(t);
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("/Server/src/main/java/txt/receipts.tx"));
			ReceiptPO temp=(ReceiptPO)in.readObject();
			Date test=new Date(temp.getCreateDate());
			if(dh.checkCBDate(test, today)){
				return temp;
			}
			else
				return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}


}
