package dataService.BankAccountdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Miscellaneous.ResultMessage;
import po.BankAccountPO;

public interface BankAccountdataService extends Remote{
	
	public void income(String name, int num) throws RemoteException;
	public void expend(String name, int num) throws RemoteException;
	public ResultMessage modifyName(String newName, String name) throws RemoteException;
	public void addAccount(BankAccountPO po) throws RemoteException;
	public ResultMessage insert(BankAccountPO po)throws RemoteException;
	public ResultMessage removeAccount(String name) throws RemoteException;
	public ArrayList<BankAccountPO> getAccount() throws RemoteException;
	public void flush() throws RemoteException;
	
}
