package vo;

/**
 * Created by admin on 15/10/25.
 */
public class BankAccountVO {

	double money;
	String name;
	
	public BankAccountVO(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	public String getName(){
		return this.name;
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

