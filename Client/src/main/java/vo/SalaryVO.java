package vo;

import java.util.Vector;

import po.SalaryPO;

public class SalaryVO extends Vector<String> {
	
	private String sum;
	
	public SalaryVO(SalaryPO po){
		if(!po.getJob().equals("司机")){
			this.add(String.valueOf(po.getSum()+"元/每月"));
		}
		else {
			this.add(String.valueOf(po.getSum()+"元/次"));
		}
	}
	
	public String getText(){
		return this.get(0);
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
