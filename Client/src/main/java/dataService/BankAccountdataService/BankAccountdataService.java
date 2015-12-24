package dataService.BankAccountdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataService.ResultMessage;

public interface BankAccountdataService extends Remote{

	public void income(String name, int num);
	public void expend(String name, int num);
	public ResultMessage modifyName(String newName, String name);
	public void addAccount(BankAccountPO po);
	public ResultMessage insert(BankAccountPO po);
	public ResultMessage removeAccount(String name);
	public ArrayList<BankAccountPO> getAccount();
	public void flush();
}
