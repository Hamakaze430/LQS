package po;

import java.io.Serializable;

public class SalaryStrategyPO implements Serializable{
	String job;
	String salary;
	
	public SalaryStrategyPO(String j,String s){
		job = j;
		salary = s;
	}

	public String getJob(){
		return job;
	}
	
	public String getSalary(){
		return salary;
	}
}
