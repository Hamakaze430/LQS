package po;

import java.io.Serializable;

public class BankAccountPO  extends PersistentObj implements Serializable{
	private static final long serialVersionUID = 1L;
	private String account;
	private String name;
	private double money;
	
	public BankAccountPO(String account, String name,double money){
		this.account = account;
		this.name = name;
		this.money = money;	
	}
	
	public String getAccount(){
		return account;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMoney(){
		return money;
	}
	
	public void changeName(String newName){
		this.name = newName;
	}
	
	public void addMoney(int num){
		this.money = this.money + num;
	}
	
	public void minusMoney(int num){
		this.money = this.money - num;
	}
	
}
