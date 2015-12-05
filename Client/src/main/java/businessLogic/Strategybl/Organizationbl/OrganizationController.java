package businessLogic.Strategybl.Organizationbl;

import java.util.ArrayList;

import javax.management.relation.Role;

import vo.EmployeeVO;
import dataService.ResultMessage;
import businessLogicService.StrategyblService.OrganizationblService;

public class OrganizationController implements OrganizationblService{
	
	OrganizationblService organization;
	
	public OrganizationController(OrganizationblService organization) {
		this.organization = organization;
	}

	public ArrayList<EmployeeVO> viewEmployeeList() {
		// TODO Auto-generated method stub
		return organization.viewEmployeeList();
	}

	public ResultMessage addEmployee(String id, String name, Role role) {
		// TODO Auto-generated method stub
		return organization.addEmployee(id, name, role);
	}

	public ResultMessage dismissEmployee(String id) {
		// TODO Auto-generated method stub
		return organization.dismissEmployee(id);
	}

}
