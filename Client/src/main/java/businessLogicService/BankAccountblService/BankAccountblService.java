package businessLogicService.BankAccountblService;

import java.util.ArrayList;

import dataService.ResultMessage;
import vo.BankAccountVO;

public interface BankAccountblService {
	
	public void addBankAccount(String name);
	
	public ResultMessage removeBankAccount(String name);
	
	public ResultMessage modifyBankAccount(String newName, String name);
	
	public ArrayList<BankAccountVO> showBankAccount(String subName);
	
}
