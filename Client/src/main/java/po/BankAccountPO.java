package po;

import java.io.Serializable;

<<<<<<< Updated upstream
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
=======
/**
 * Created by admin on 15/10/25.
 */
public class BankAccountPO implements Serializable {
    int id;
    String name;
    double balance;

    public BankAccountPO(String name, double balance){
        this.name=name;
        this.balance=balance;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }
>>>>>>> Stashed changes
}
