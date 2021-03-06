package data.BankAccountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Miscellaneous.ResultMessage;
import po.BankAccountPO;
import dataService.BankAccountdataService.BankAccountdataService;

public class BankAccountdataImpl extends UnicastRemoteObject implements BankAccountdataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BankAccountDAO bankaccountDAO;
	
	public BankAccountdataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		bankaccountDAO = new BankAccountFileDAO("bankAccount");
	}


	public void income(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.income(name, num);
	}

	public void expend(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.expend(name, num);
	}

	public ResultMessage modifyName(String newName, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.modify(newName, name);
	}

	public void addAccount(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		bankaccountDAO.add(po);
		
	}

	public ResultMessage removeAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub		
		return bankaccountDAO.remove(name);
	}

	public ArrayList<BankAccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.showAll();
	}


	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.flush();
	}


	public ResultMessage insert(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.insert(po);
	}

}
