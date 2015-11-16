package businessLogicService.BankAccountblService;

import vo.BankAccountVO;

public interface BankAccountblService {
	
	public BankAccountVO findBankAccountInfo(String id);
	
	public boolean addBankAccountVO(BankAccountVO bankaccount);
	
	public boolean deleteBankAccountVO(BankAccountVO bankaccount);
	
	public boolean updateBankAccountVO(BankAccountVO bankaccount);

}
