package data.Strategydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataService.StrategydataService.SalarydataService.SalarydataService;
import po.SalaryPO;

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

	public SalaryPO getPO(String job) {
		SalaryPO po = new SalaryPO();
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/salary.ser"));
			SalaryPO temp;
			while((temp = (SalaryPO) in.readObject())!= null){
				if(temp.getJob().equals(job)){
					po=temp;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}


	public void setSalary(String job, String newSalary) throws RemoteException{
		SalaryPO po;
		po = this.getPO(job);
		double temp = po.getSum() + Double.parseDouble(newSalary);
		po.setSum(temp);
	}
	
	public void setSalary(String job, double rate) throws RemoteException{
		SalaryPO po;
		po = this.getPO(job);
		double temp = po.getSum();
		temp *= rate;
		po.setSum(temp);
	}

	
	/*
	 * old version below....sorry i had to write a new one orz
	 * 
	 * */
	
//	public void setClerkSalary(double salary) throws RemoteException {
//		// TODO Auto-generated method stub
//		salaryDAO.setClerkSalary(salary);
//	}
//
//	public void setDriverWage(double wage) throws RemoteException {
//		// TODO Auto-generated method stub
//		salaryDAO.setDriverWage(wage);
//	}
//
//	public void setPostmanWage(double wage) throws RemoteException {
//		// TODO Auto-generated method stub
//		salaryDAO.setPostmanWage(wage);
//	}
//
//	public double getClerkSalary() throws RemoteException {
//		// TODO Auto-generated method stub
//		return salaryDAO.getClerkSalary();
//	}
//
//	public double getDriverWage() throws RemoteException {
//		// TODO Auto-generated method stub
//		return salaryDAO.getDriverWage();
//	}
//
//	public double getPostmanWage() throws RemoteException {
//		// TODO Auto-generated method stub
//		return salaryDAO.getPostmanWage();
//	}
//
//	public void flush() throws RemoteException {
//		// TODO Auto-generated method stub
//		salaryDAO.flush();
//	}

}
