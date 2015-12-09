package data.Strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataService.StrategydataService.SalarydataService.SalarydataService;

public class SalarydataServiceImpl extends UnicastRemoteObject implements SalarydataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	SalaryDAO salaryDAO;
	

	public SalarydataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		salaryDAO = new SalaryFileDAO("salary");
	}

	@Override
	public void setClerkSalary(double salary) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDAO.setClerkSalary(salary);
	}

	@Override
	public void setDriverWage(double wage) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDAO.setDriverWage(wage);
	}

	@Override
	public void setPostmanWage(double wage) throws RemoteException {
		// TODO Auto-generated method stub
		salaryDAO.setPostmanWage(wage);
	}

	@Override
	public double getClerkSalary() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDAO.getClerkSalary();
	}

	@Override
	public double getDriverWage() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDAO.getDriverWage();
	}

	@Override
	public double getPostmanWage() throws RemoteException {
		// TODO Auto-generated method stub
		return salaryDAO.getPostmanWage();
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		salaryDAO.flush();
	}

}
