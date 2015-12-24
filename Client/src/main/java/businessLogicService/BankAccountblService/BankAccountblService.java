package businessLogicService.BankAccountblService;

import java.util.ArrayList;

import dataService.ResultMessage;
import vo.BankAccountVO;

public interface BankAccountblService {
	
	public void addBankAccount(BankAccountVO vo);
	
	public ResultMessage removeBankAccount(String name);
	
	public ResultMessage modifyBankAccount(String newName, String name);
	
	public ArrayList<BankAccountVO> showBankAccount(String subName);

	public BankAccountVO find(String accountId);

	public void incMoney(String amount);

	public void decMoney(String account, String amount);
	
}
