package businessLogic.BankAccountbl;

import init.RMIHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataService.ResultMessage;
import dataService.BankAccountdataService.BankAccountdataService;
import vo.BankAccountVO;
import businessLogicService.BankAccountblService.BankAccountblService;

public class BankAccountbl implements BankAccountblService, BankAccountInfo{
	
	BankAccountdataService bankaccountDataService;
	
	public BankAccountbl(){
		bankaccountDataService = RMIHelper.getBankAccountdataService();
	}

	public void addBankAccount(String name) {	
		try {
			bankaccountDataService.addAccount(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	public ResultMessage removeBankAccount(String name) {
		ResultMessage result = ResultMessage.FAILURE;
		
		try {
			result = bankaccountDataService.removeAccount(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public ResultMessage modifyBankAccount(String newName, String name) {
		
		ResultMessage result = ResultMessage.FAILURE;
		
		try {
			result = bankaccountDataService.modifyName(newName, name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public ArrayList<BankAccountVO> showBankAccount(String subName) {
		
		try {
			ArrayList<BankAccountPO> poList = bankaccountDataService.getAccount();
			ArrayList<BankAccountVO> voList = new ArrayList<BankAccountVO>();
			for(int i=0;i<poList.size();i++){
				BankAccountPO tempo = poList.get(i);
				String name = tempo.getName();
				if(name.contains(subName)){
					voList.add(new BankAccountVO(name,tempo.getMoney()));
				}
			}
			return voList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
    public void modify(int modify,String name) {
    		
    	try {
		    if(modify>=0)
				bankaccountDataService.income(name, modify);
			else
		    	bankaccountDataService.expend(name, -modify);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}	
	
	public int getMoney(String name){
			
		double result = -1;
		
		try {
			ArrayList<BankAccountPO> accountList = bankaccountDataService.getAccount();
			for(int i=0;i<accountList.size();i++)
				if(accountList.get(i).getName().equals(name))
					result = accountList.get(i).getMoney();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return (int) result;

    }

	public ArrayList<BankAccountVO> getAllAccounts() {
		
		try {
			ArrayList<BankAccountPO>  poList = bankaccountDataService.getAccount();
			ArrayList<BankAccountVO> voList = new ArrayList<BankAccountVO>();
			for(int i=0;i<poList.size();i++){
				voList.add(new BankAccountVO(poList.get(i).getName(),poList.get(i).getMoney()));
			}
			return voList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
