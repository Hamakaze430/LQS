package vo;

import java.util.Vector;

import po.BankAccountPO;

/**
 * Created by admin on 15/10/25.
 */
public class BankAccountVO extends Vector<String>{

	private String account;
	private String name;
	private double cost;
	private double money;
	
	public BankAccountVO(BankAccountPO po){
		account=po.getAccount();
		name=po.getName();
		cost=po.getMoney();
	}

	public BankAccountVO(String account, String name, String cost){
		this.add(account);
		this.add(name);
		this.add(cost);	
	}
	
	public String getAccount(){
		return account;
	}

	public BankAccountVO(String account, String name,double money){
		this.account = account;
		this.name=name;
		this.money=money;
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

