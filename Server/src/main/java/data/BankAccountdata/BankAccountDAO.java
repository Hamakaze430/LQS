package data.BankAccountdata;

import java.util.ArrayList;

import Miscellaneous.ResultMessage;
import po.BankAccountPO;

public interface BankAccountDAO {
	public void add(BankAccountPO po);
    public ResultMessage remove(String name);
    public ArrayList<BankAccountPO> getAll();
    public ResultMessage modify(String newname, String name);
    public void income(String name, int num);
    public void expend(String name, int num);
    public ArrayList<BankAccountPO> showAll();
    public void flush();
    public ResultMessage insert(BankAccountPO po);

}
