package businessLogic.BankAccountbl;

import java.util.ArrayList;

import vo.BankAccountVO;

public interface BankAccountInfo {
   public void modify(int pay,String account) ;
	
	public ArrayList<BankAccountVO> getAllAccounts();
	
	public int getMoney(String account);

}
