package po;

import java.io.Serializable;

public class BankAccountPO implements Serializable {
    String id;
    String name;
    String balance;

    public BankAccountPO(String name, String balance){
        this.name=name;
        this.balance=balance;
    }

    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getBalance(){
        return balance;
    }

}
