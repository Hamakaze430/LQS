package data.Strategydata;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataService.StrategydataService.SalarydataService.SalarydataService;
import po.HallPO;
import po.SalaryPO;

public class SalarydataServiceImpl extends UnicastRemoteObject implements SalarydataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
//	SalaryDAO salaryDAO;

	public SalarydataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
//		salaryDAO = new SalaryFileDAO("salary");
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public SalaryPO getPO(String job) {
		SalaryPO po = new SalaryPO();
		po.setJob(job);
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/salary.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<SalaryPO> list = (List<SalaryPO>) objectIn.readObject();
			for(SalaryPO temp: list){
				if(temp.getJob().equals(job)){
					po = temp;
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
		double temp = Double.parseDouble(newSalary);
		po.setSum(temp);
		update(po);
	}
	
	public void setSalary(String job, double rate) throws RemoteException{
		SalaryPO po;
		po = this.getPO(job);
		po.setSum(rate);
		update(po);
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	private boolean update(SalaryPO po) throws RemoteException {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/ser/salary.ser");
			BufferedInputStream buffered = new BufferedInputStream(fileIn);	
	        ObjectInputStream objectIn = new ObjectInputStream(buffered);  	   
	        List<SalaryPO> list = (List<SalaryPO>) objectIn.readObject();
//			List<SalaryPO> list = new ArrayList<SalaryPO>();
			int index = -1;
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getJob().equals(po.getJob())){
					index = i;
					break;
				}
			}
			list.add(po);
            FileOutputStream fileOut = new FileOutputStream("src/main/java/ser/salary.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(list);
			objectOut.close();
            return true;
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
		return false;
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
