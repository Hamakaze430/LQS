package businessLogic.Strategybl;

import java.util.ArrayList;

import javax.management.relation.Role;

import vo.EmployeeVO;
import dataService.ResultMessage;

public interface UserCreateMessageInfo {

	public ResultMessage createUserMessage(StaffChange change,String id, String name, Role role);

	public ArrayList<EmployeeVO> viewEmployeeList();
}
