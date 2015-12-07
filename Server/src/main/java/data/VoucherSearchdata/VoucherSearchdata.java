package data.VoucherSearchdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import po.VoucherSearchPO;
import po.receipts.IncomePO;
import dataService.VoucherSearchdataService.VoucherSearchdataService;

public class VoucherSearchdata implements VoucherSearchdataService{

	@Override
	public ArrayList<IncomePO> getbyDate(String date) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/voucher.ser"));
			IncomePO temp=(IncomePO) in.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<IncomePO> getbyHall(String hall) {
		// TODO Auto-generated method stub
		return null;
	}

}
