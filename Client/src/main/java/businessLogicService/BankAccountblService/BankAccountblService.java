package businessLogicService.BankAccountblService;

import vo.BankAccountVO;

public interface BankAccountblService {
	
public BankAccountVO addBankAccount(String id,String name,double balance);
	
	public boolean deleteBankAccountVO(int index);
	
	public double getTotalBalance();
	
	public boolean save();

}
