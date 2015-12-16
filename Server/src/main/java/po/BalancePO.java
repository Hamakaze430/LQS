package po;

import java.io.Serializable;

import Miscellaneous.Item;



public class BalancePO implements Serializable{
private static final long serialVersionUID = 1L;

	String date;
    String id;
	double money;
	String name;
	String bankaccount;
	Item item;
	String remark;

	
	public BalancePO(String date,double money,String name,String bankaccount,Item item,String remark) {
		// TODO Auto-generated constructor stub
	
	this.date = date;
	this.money = money;
	this.name = name;
	this.bankaccount = bankaccount;
	this.item = item;
	this.remark = remark;
	
	
	id= "Cost"+date+money+name+remark;
	}
	
	
	
	public double getMoney(){
		return money;
	}
	
	public String getName(){
		return name;
	}
	
	public String getBankAccount(){
		return bankaccount;
	}
	
	public Item getItem(){
		return item;
	}
	
	public String getRemark(){
		return remark;
	}

	public String getDate() {
		return date;
	}

}
