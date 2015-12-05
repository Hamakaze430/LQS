package businessLogic.Userbl;

import po.UserPO;
import dataService.DataFactoryService.DataFactoryService;
import dataService.UserdataService.UserdataService;
import init.Client;
import businessLogicService.UserblService.UserblService;
import vo.Authorities;
import vo.UserVO;

public class User implements UserblService{
	
	private DataFactoryService dataFactory;
	private UserdataService userdata;
	
	public User(){
	    	dataFactory=Client.dataFactory;
			userdata=dataFactory.getUserdataService();
	}	

	public boolean addUser(UserVO user) {
		UserPO po=new UserPO(user);
		userdata.add(po);
		return false;
	}

	public String getHallId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHallName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasTheAuthority(Authorities one) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getUserSex() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCompanyName() {
		// TODO Auto-generated method stub
		return null;
	}

}
