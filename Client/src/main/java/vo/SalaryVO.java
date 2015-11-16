package vo;

public class SalaryVO {
	private String position;
	private double salary;
	
	
	public SalaryVO(String position,double salary){
		this.position=position;
		this.salary=salary;
		
	}
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	public double getsalary(){
		return salary;
	}
	
	public void setsalary(double salary){
		this.salary = salary;
	}
	
	
}
