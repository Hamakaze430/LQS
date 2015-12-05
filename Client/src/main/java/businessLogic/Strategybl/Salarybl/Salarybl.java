package businessLogic.Strategybl.Salarybl;

import java.rmi.RemoteException;

import init.RMIHelper;
import vo.SalaryVO;
import dataService.ResultMessage;
import dataService.StrategydataService.SalarydataService.SalarydataService;
import businessLogicService.StrategyblService.SalaryblService;

public class Salarybl implements SalaryblService{
	public static SalarydataService salaryDataService= RMIHelper.getSalaryDataService();

	public ResultMessage setClerkSalary(double salary) {
		// TODO Auto-generated method stub

		if (salary <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.clerkSalary = salary;
		try {
			salaryDataService.setClerkSalary(salary);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;

	}

	public ResultMessage setDriverWage(double wage) {
		// TODO Auto-generated method stub

		if (wage <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.driverWage = wage;
		try {
			salaryDataService.setDriverWage(wage);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage setPostmanWage(double wage) {
		// TODO Auto-generated method stub
		if (wage <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.postmanWage = wage;
		try {
			salaryDataService.setPostmanWage(wage);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}
	
	public static double getClerkSalary(){
		try {
			return salaryDataService.getClerkSalary();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static double getDriverWage(){
		try {
			return salaryDataService.getDriverWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public static double getPostmanWage(){
		try {
			return salaryDataService.getPostmanWage();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public SalaryVO getSalary() {
		// TODO Auto-generated method stub
		try {
			return new SalaryVO(salaryDataService.getClerkSalary(),salaryDataService.getDriverWage(), salaryDataService.getPostmanWage());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
