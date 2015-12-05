package businessLogicService.StrategyblService;

import java.util.ArrayList;

import javax.management.relation.Role;

import dataService.ResultMessage;
import vo.EmployeeVO;

public interface OrganizationblService {
    public ArrayList<EmployeeVO> viewEmployeeList();
	
	public ResultMessage addEmployee(String id, String name, Role role);
	
	public ResultMessage dismissEmployee(String id);

}
