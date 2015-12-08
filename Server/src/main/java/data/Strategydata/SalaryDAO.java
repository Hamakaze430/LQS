package data.Strategydata;

import po.SalaryPO;

public interface SalaryDAO {
    public void setClerkSalary(double salary) ;
	
	public void setDriverWage(double wage) ;
	
	public void setPostmanWage(double wage) ;
	
	public double getClerkSalary();
	
	public double getDriverWage();
	
	public double getPostmanWage() ;
	
	public SalaryPO read();
	
	public void flush();
}