package vo;

/**
 * Created by admin on 15/10/25.
 */
public class BankAccountVO {
	private String id;
	private String name;
	private double balance;
	
	public BankAccountVO(String id,String name,double balance){
		this.id=id;
		this.name=name;
		this.balance=balance;
		
	}
	
	public String getID(){
		return id;
	}
	
	public void setID(){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(){
		this.name=name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(){
		this.balance=balance;
	}
}
