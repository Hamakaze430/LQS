package businessLogic.BankAccountbl;

import java.util.ArrayList;

import po.BankAccountPO;
import dataService.BankAccountdataService.BankAccountdataService;
import dataService.DataFactoryService.DataFactory;
import vo.BankAccountVO;
import businessLogicService.BankAccountblService.BankAccountblService;

public class BankAccountbl implements BankAccountblService{

	private DataFactory dataFactory;
	private ArrayList<BankAccountVO> bankaccountList;
	private double totalBalance;
	
	public BankAccountbl(){
		dataFactory = new DataFactory();
		bankaccountList = new ArrayList<BankAccountVO>();
	}
	
	public BankAccountVO addBankAccount(String id, String name, double balance) {
		BankAccountVO bankaccount = new BankAccountVO(id,name,balance);
	    bankaccountList.add(bankaccount);
		this.totalBalance += balance;

		return bankaccount;
	}
	public boolean deleteBankAccountVO(int index) {
		BankAccountVO bankaccount = bankaccountList.get(index);
		totalBalance -= bankaccount.getBalance();
		bankaccountList.remove(bankaccount);
		return true;
	}
	public double getTotalBalance() {
		return totalBalance;
	}

	public boolean save() {
		BankAccountdataService data = dataFactory.getBankAccountData();
		
		for(int i = 0; i<bankaccountList.size();i++){
			BankAccountVO vo = bankaccountList.get(i);
			String bankaccount_id = vo.getID();
			String bankaccount_name=vo.getName();
			double bankaccount_balance = vo.getBalance();
			
			BankAccountPO bankaccount = new BankAccountPO(bankaccount_id,bankaccount_name,bankaccount_balance);
			boolean result = data.insert(bankaccount);
		}
		return result;
	}
	



}
