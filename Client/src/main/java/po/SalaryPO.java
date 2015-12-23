package po;

import java.io.Serializable;

public class SalaryPO implements Serializable{
	private static final long serialVersionUID = -9132465046645093029L;

	private String job;
	private double sum;
	
	public SalaryPO(){}
	
	public SalaryPO(String job, double sum){
		this.job=job;
		this.sum=sum;
	}
	
	public void setSum(double newSum){
		sum = newSum;
	}
	
	public String getJob(){
		return job;
	}
	
	public double getSum(){
		return sum;
	}
	
//	private double clerkSalary;
//	
//	private double driverWage;
//	
//	private double postmanWage;
//
//	
//	public SalaryPO(double clerkSalary ,double driverWage,double  postmanWage) {
//		
//		this.clerkSalary = clerkSalary;
//		this.driverWage = driverWage;
//		this.postmanWage = postmanWage;
//	}
//	
//	public double getClerkSalary() {
//		return clerkSalary;
//	}
//
//	public double getDriverWage() {
//		return driverWage;
//	}
//
//	public double getPostmanWage() {
//		return postmanWage;
//	}
//
//	public void setClerkSalary(double clerkSalary) {
//		this.clerkSalary = clerkSalary;
//	}
//
//	public void setDriverWage(double driverWage) {
//		this.driverWage = driverWage;
//	}
//
//	public void setPostmanWage(double postmanWage) {
//		this.postmanWage = postmanWage;
//	}	
}