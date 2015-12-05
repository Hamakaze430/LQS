package businessLogic.Strategybl.Organizationbl;

import java.util.ArrayList;

import javax.management.relation.Role;

import vo.EmployeeVO;
import dataService.ResultMessage;
import businessLogic.Strategybl.StaffChange;
import businessLogic.Strategybl.UserCreateMessageInfo;
import businessLogicService.StrategyblService.OrganizationblService;

public class Organizationbl implements OrganizationblService{
	
   UserCreateMessageInfo userBL;
	
	public Organizationbl(UserCreateMessageInfo userBL) {
		this.userBL = userBL;
	}

	public ArrayList<EmployeeVO> viewEmployeeList() {
		// TODO Auto-generated method stub
		return userBL.viewEmployeeList();
	}

	public ResultMessage addEmployee(String id, String name, Role role) {
		// TODO Auto-generated method stub
		return userBL.createUserMessage(StaffChange.add, id, name, role);
	}

	public ResultMessage dismissEmployee(String id) {
		// TODO Auto-generated method stub
		return userBL.createUserMessage(StaffChange.delete, id, null, null);
	}

}
