package data.BankAccountdata;

import po.BankAccountPO;
import Common.CommonData;
import Miscellaneous.ResultMessage;

public class BankAccountFileDAO extends CommonData<BankAccountPO> implements BankAccountDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(BankAccountPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

	@Override
	public ResultMessage remove(String name) {
		// TODO Auto-generated method stub
		return delete(name);
	}

	@Override
	public ResultMessage modify(String newname, String name) {
		// TODO Auto-generated method stub
		BankAccountPO po = this.find(name);
		ResultMessage result = delete(name);
		
		if(result==ResultMessage.SUCCESS)
			po.changeName(newname);
		
		insert(po);
		
		return result;
	}

	@Override
	public void income(String name, int num) {
		// TODO Auto-generated method stub
		BankAccountPO po = find(name);
		po.addMoney(num);
		update(name,po);
	}

	@Override
	public void expend(String name, int num) {
		// TODO Auto-generated method stub
		BankAccountPO po = find(name);
		po.minusMoney(num);
		update(name,po);
	}

}

