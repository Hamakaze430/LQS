package businessLogicService.StrategyblService;

import vo.SalaryVO;
import dataService.ResultMessage;

public interface SalaryblService {
    public  ResultMessage setClerkSalary(double salary);
	
	public ResultMessage setDriverWage(double wage);
	
	public ResultMessage setPostmanWage(double wage);
	
	public SalaryVO getSalary();

}
