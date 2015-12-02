package data.BankAccountdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import po.BankAccountPO;
import dataService.BankAccountdataService.BankAccountdataService;

public class BankAccountdataImpl implements BankAccountdataService {

	public ArrayList<BankAccountPO> getAllAccounts() {
		ArrayList<BankAccountPO> list=new ArrayList<BankAccountPO>();
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/bankAccount.ser"));
			BankAccountPO temp;
			while((temp=(BankAccountPO)in.readObject())!=null){
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
