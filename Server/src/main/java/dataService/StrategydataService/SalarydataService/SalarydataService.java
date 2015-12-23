package dataService.StrategydataService.SalarydataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.SalaryPO;

public interface SalarydataService extends Remote{

	public SalaryPO getPO(String job) throws RemoteException;
	
	public void setSalary(String job, String newSalary) throws RemoteException;
	
	public void setSalary(String job, double rate) throws RemoteException;
	
//    public void setClerkSalary(double salary) throws RemoteException;
//	
//	public void setDriverWage(double wage) throws RemoteException;
//	
//	public void setPostmanWage(double wage) throws RemoteException;
//	
//	public double getClerkSalary()throws RemoteException;
//	
//	public double getDriverWage()throws RemoteException;
//	
//	public double getPostmanWage() throws RemoteException;
//	
//	public void flush() throws RemoteException;
	
}
