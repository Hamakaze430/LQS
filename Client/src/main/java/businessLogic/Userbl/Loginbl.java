package businessLogic.Userbl;

import po.LoginPO;
import dataService.DataFactoryService.DataFactoryService;
import init.RMIHelper;
import vo.LoginVO;
import businessLogicService.UserblService.LoginblService;

public class Loginbl implements LoginblService{
	private DataFactoryService dataFactory;
	public Loginbl(){
		dataFactory = RMIHelper.getDataFactory();
	}
	public LoginVO login(String id,String word) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
