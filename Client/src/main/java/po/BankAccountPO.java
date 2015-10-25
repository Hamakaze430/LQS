package po;

import java.io.Serializable;

public class BankAccountPO implements Serializable{
	int id;
	String balance;
	
	public BankAccountPO(int i,String b){
		id = i;
		balance = b;
		
	}
	
	public int getID(){
		return id;
	}

	public String getBalance(){
		return balance;
	}
}
