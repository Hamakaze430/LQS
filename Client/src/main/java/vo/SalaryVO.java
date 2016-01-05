package vo;

import java.util.Vector;

import po.SalaryPO;

public class SalaryVO {
	
	private String job;
	private double sum;
	
	public SalaryVO(SalaryPO po){	
		this.job = po.getJob();
		this.sum = po.getSum();
	}
	
	public String getText(){
		if(job.equals("快递员")){
			return (int)(sum*100)+"%";
		}
		
		if(!job.equals("司机")){
			return sum+"元/月";
		}
		
		return sum+"元/次";
		
	}
	
//	   private double clerkSalary;
//		
//		private double driverWage;
//		
//		private double postmanWage;
		
		
		
//		public SalaryVO(double clerkSalary,double driverWage,double postmanWage) {
//			
//			this.clerkSalary = clerkSalary;
//			this.driverWage = driverWage;
//			this.postmanWage = postmanWage;	
//		}
			
//		public double getClerkSalary() {
//			return clerkSalary;
//		}
//
//		public double getDriverWage() {
//			return driverWage;
//		}
//
//		public double getPostmanWage() {
//			return postmanWage;
//		}
	
}
