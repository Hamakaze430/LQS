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


	@Override
	public void income(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.income(name, num);
	}

	@Override
	public void expend(String name, int num) throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.expend(name, num);
	}

	@Override
	public ResultMessage modifyName(String newName, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.modify(newName, name);
	}

	@Override
	public void addAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
		bankaccountDAO.add(new BankAccountPO(name, 0));
		
	}

	@Override
	public ResultMessage removeAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub		
		return bankaccountDAO.remove(name);
	}

	@Override
	public ArrayList<BankAccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.showAll();
	}


	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		bankaccountDAO.flush();
	}


	@Override
	public ResultMessage insert(BankAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return bankaccountDAO.insert(po);
	}

}
