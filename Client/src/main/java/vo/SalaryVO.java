
public class SalaryVO {
	private double salary;
	private double bonus;
	
	public SalaryVO(double salary,double bonus){
		this.salary=salary;
		this.bonus=bonus;
	}
	
	public double getsalary(){
		return salary;
	}
	
	public void setsalary(double salary){
		this.salary = salary;
	}
	
	public double getbonus(){
		return bonus;
	}
	
	public void setbonus(double bonus){
		this.bonus = bonus;
	}
}
