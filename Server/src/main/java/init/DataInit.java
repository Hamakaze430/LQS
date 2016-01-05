package init;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import po.BankAccountPO;

public class DataInit {

	public static void main(String[] args){
		BankAccountPO ba1=new BankAccountPO("0001", "Account 1", 1000);
		BankAccountPO ba2=new BankAccountPO("0002", "Account 2", 1400);
		BankAccountPO ba3=new BankAccountPO("0003", "Account 3", 3200);
		BankAccountPO ba4=new BankAccountPO("0004", "Account 4", 1200);
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("src/main/java/ser/bankAccount.ser"));
			out.writeObject(ba1);
			out.writeObject(ba2);
			out.writeObject(ba3);
			out.writeObject(ba4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
}
