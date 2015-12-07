package vo;

import Miscellaneous.Item;

public class BalanceVO {
	String date;
	double money;
	String name;
	String bankaccount;
	Item item;
	String remark;
	String id;
	
	public BalanceVO(String date,double money,String name,String bankaccount,Item item,String remark) {
		// TODO Auto-generated constructor stub
	
	this.date = date;
	this.money = money;
	this.name = name;
	this.bankaccount = bankaccount;
	this.item = item;
	this.remark = remark;
	
	
	id="Cost"+ date+money+name+remark;
	}
	
	
	
	public String getDate(){
		return date;
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
	
	
	public String toString(){
		return "Date: "+date+"   Money:"+money+"    Name:"+name+"     Bank Account:"+bankaccount+"       +Item:"+item+"     Remark:"+remark;
	}
}
