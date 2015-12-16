package dataService.StrategydataService.SalarydataService;

import java.rmi.RemoteException;

public interface SalarydataService {
	 public void setClerkSalary(double salary) throws RemoteException;
		
		public void setDriverWage(double wage) throws RemoteException;
		
		public void setPostmanWage(double wage) throws RemoteException;
		
		public double getClerkSalary()throws RemoteException;
		
		public double getDriverWage()throws RemoteException;
		
		public double getPostmanWage() throws RemoteException;
		
		public void flush() throws RemoteException;

}
