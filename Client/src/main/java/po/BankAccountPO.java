package po;

import java.io.Serializable;

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

}
