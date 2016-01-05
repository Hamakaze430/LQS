package businessLogic.Strategybl.Salarybl;

import java.rmi.RemoteException;

import po.SalaryPO;
import init.RMIHelper;
import vo.SalaryVO;
import dataService.ResultMessage;
import dataService.StrategydataService.SalarydataService.SalarydataService;
import businessLogic.Strategybl.Role;
import businessLogicService.StrategyblService.SalaryblService;

public class Salarybl implements SalaryblService{
	
	private static SalarydataService salaryData = RMIHelper.getSalaryDataService();

	public SalaryVO getSalary(Role role) {
		// TODO Auto-generated method stub
		try {
			SalaryPO po = salaryData.getPO(role.getName());
			return new SalaryVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public void setSalary(Role role, String newSum, double rate) {
		// TODO Auto-generated method stub		
		switch(role){
		case MANAGER:
		case CLERK_STATION:
		case CLERK_HALL:
		case STOREKEEPER:
		case HIGHERFINANCE:
		case LOWERFINANCE:
		case ADMINISTRATOR:
		case DRIVER:
			try {
				salaryData.setSalary(role.getName(), newSum);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case POSTMAN:
			try {
				salaryData.setSalary(role.getName(), rate);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
//	public ResultMessage setClerkSalary(double salary) {
//		// TODO Auto-generated method stub
//
//		if (salary <= 0)
//			return ResultMessage.FAILURE;
////		BasicValues.clerkSalary = salary;
//		try {
//			salaryDataService.setClerkSalary(salary);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ResultMessage.SUCCESS;
//
//	}
//
//	public ResultMessage setDriverWage(double wage) {
//		// TODO Auto-generated method stub
//
//		if (wage <= 0)
//			return ResultMessage.FAILURE;
////		BasicValues.driverWage = wage;
//		try {
//			salaryDataService.setDriverWage(wage);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ResultMessage.SUCCESS;
//	}
//
//	public ResultMessage setPostmanWage(double wage) {
//		// TODO Auto-generated method stub
//		if (wage <= 0)
//			return ResultMessage.FAILURE;
////		BasicValues.postmanWage = wage;
//		try {
//			salaryDataService.setPostmanWage(wage);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ResultMessage.SUCCESS;
//	}
//	
//	public static double getClerkSalary(){
//		try {
//			return salaryDataService.getClerkSalary();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
//	public static double getDriverWage(){
//		try {
//			return salaryDataService.getDriverWage();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
//	
//	public static double getPostmanWage(){
//		try {
//			return salaryDataService.getPostmanWage();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	public SalaryVO getSalary() {
//		// TODO Auto-generated method stub
//		try {
//			return new SalaryVO(salaryDataService.getClerkSalary(),salaryDataService.getDriverWage(), salaryDataService.getPostmanWage());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
