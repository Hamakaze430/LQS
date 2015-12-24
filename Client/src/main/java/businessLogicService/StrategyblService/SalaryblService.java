package businessLogicService.StrategyblService;

import businessLogic.Strategybl.Role;
import vo.SalaryVO;
import dataService.ResultMessage;

public interface SalaryblService {
//    public  ResultMessage setClerkSalary(double salary);
//	
//	public ResultMessage setDriverWage(double wage);
//	
//	public ResultMessage setPostmanWage(double wage);
//	
	public SalaryVO getSalary(Role role);
	
	public void setSalary(Role role, String newSum, double rate);
	
//	public void setSalary(Role role, double rate);

}
