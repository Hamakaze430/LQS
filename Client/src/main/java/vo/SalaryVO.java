package vo;

public class SalaryVO {
	   private double clerkSalary;
		
		private double driverWage;
		
		private double postmanWage;
		
		
		
		public SalaryVO(double clerkSalary,double driverWage,double postmanWage) {
			
			this.clerkSalary = clerkSalary;
			this.driverWage = driverWage;
			this.postmanWage = postmanWage;	
		}
			
		public double getClerkSalary() {
			return clerkSalary;
		}

		public double getDriverWage() {
			return driverWage;
		}

		public double getPostmanWage() {
			return postmanWage;
		}
	
}
