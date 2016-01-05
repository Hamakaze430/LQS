package businessLogic.BankAccountbl;

import init.RMIHelper;
import po.BankAccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.ResultMessage;
import dataService.BankAccountdataService.BankAccountdataService;
import vo.BankAccountVO;
import businessLogicService.BankAccountblService.BankAccountblService;

public class BankAccountbl implements BankAccountblService, BankAccountInfo{
	
	BankAccountdataService bankaccountDataService;
	
	public BankAccountbl(){
		bankaccountDataService = RMIHelper.getBankAccountdataService();
	}

	public void addBankAccount(BankAccountVO vo) {	
		
			bankaccountDataService.addAccount(new BankAccountPO(vo.getAccount(),vo.getName(),vo.getMoney()));
		
		
	}

	public ResultMessage removeBankAccount(String name) {
		ResultMessage result = ResultMessage.FAILURE;
		
		result = bankaccountDataService.removeAccount(name);
		
		
		return result;
		
	}

	public ResultMessage modifyBankAccount(String newName, String name) {
		
		ResultMessage result = ResultMessage.FAILURE;
		
		result = bankaccountDataService.modifyName(newName, name);
		
		
		return result;
	}


	public ArrayList<BankAccountVO> showBankAccount(String subName) {
		
		ArrayList<BankAccountPO> poList = bankaccountDataService.getAccount();
		ArrayList<BankAccountVO> voList = new ArrayList<BankAccountVO>();
		for(int i=0;i<poList.size();i++){
			BankAccountPO tempo = poList.get(i);
			String name = tempo.getName();
			if(name.contains(subName)){
				voList.add(new BankAccountVO(tempo.getAccount(),name,String.valueOf(tempo.getMoney())));
			}
		}
		return voList;
		
		
	}
	
    public void modify(int modify,String name) {
    	if(modify>=0)
			bankaccountDataService.income(name, modify);
		else
	    	bankaccountDataService.expend(name, -modify);		
		
	}	
	
	public int getMoney(String name){
			
		double result = -1;
		ArrayList<BankAccountPO> accountList = bankaccountDataService.getAccount();
		for(int i=0;i<accountList.size();i++)
			if(accountList.get(i).getName().equals(name))
				result = accountList.get(i).getMoney();
	
		return (int) result;
			

    }

	public ArrayList<BankAccountVO> getAllAccounts() {
		ArrayList<BankAccountPO>  poList = bankaccountDataService.getAccount();
		ArrayList<BankAccountVO> voList = new ArrayList<BankAccountVO>();
		for(int i=0;i<poList.size();i++){
			voList.add(new BankAccountVO(poList.get(i).getName(), poList.get(i).getMoney()));
		}
		return voList;
		
	}


	public BankAccountVO find(String accountId) {
		ArrayList<BankAccountPO> poList = bankaccountDataService.getAccount();
		for (BankAccountPO po : poList){
			if (po.getAccount().equals(accountId))
				return new BankAccountVO(po.getName(), po.getMoney());
		}
		
		return null;
	}
	
	public void incMoney(String amount) {
		// TODO Auto-generated method stub
		
	}

	public void decMoney(String account, String amount) {
		// TODO Auto-generated method stub
	}
	
}
