package po;

import java.io.Serializable;

public class BankAccountPO   implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String name;
	double money;
	
	public BankAccountPO(String name,double money){
		
		this.name = name;
		this.money = money;	
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
