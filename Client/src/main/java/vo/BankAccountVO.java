package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class BankAccountVO{

	double money;
	String name;
	public BankAccountVO(String account, String name, String cost){
		this.add(account);
		this.add(name);
		this.add(cost);	
	}
	
	public String getAccount(){
		return get(0);
	}

	public BankAccountVO(String name,double money){
		this.name=name;
		this.money=money;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMoney(){	
		return money;
	}
	
	public void addMoney(int num){
		money += num;
	}
	
	public void minusMoney(int num){
		money -= num;
	}
	
	public void changeName(String newName){
		name = newName;
	}
}

