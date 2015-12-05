package businessLogic.Userbl;

import po.LoginPO;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import init.RMIHelper;
import vo.LoginVO;
import businessLogicService.UserblService.LoginblService;

public class Loginbl implements LoginblService{
	private DataFactoryService dataFactory;
	public Loginbl(){
		dataFactory = Client.dataFactory;
	}
	public LoginVO login(String id,String word) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
