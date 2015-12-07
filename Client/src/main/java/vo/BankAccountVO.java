package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class BankAccountVO extends Vector<String>{

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

	public String getName(){
		return get(1);
	}

	public String getMonny(){
		return get(2);
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

