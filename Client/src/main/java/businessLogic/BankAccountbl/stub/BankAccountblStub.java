package businessLogic.BankAccountbl.stub;


public interface BankAccountblService_Stud  implements BankAccountblService{
	String bankaccountid;
	String bankaccountbalance;
	
	public BankAccountblService_Stud(String bai,String bab){
		bankaccountid = bai;
		bankaccountbalance = bab;
	}
	
	public BankAccountVO getBankAccountID(String bankaccountid){
		return new BankAccountVO(bankaccountid);
	}
	
	public BankAccountVO getBankAccountBalance(String bankaccountbalance){
		return new BankAccountVO(bankaccountbalance);
	}
	
	public ResultMessage addBankAccount(String bankaccountid,String bankaccountbalance){
		if(bankaccountid == 00001)
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}
	
	public ResultMessage deleteBankAccount(String bankaccount,String bankaccountbalance){
		
	}
	
	public class BankAccountView{
		
	}
	

}