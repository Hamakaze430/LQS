package businessLogic.Userbl;

import po.UserPO;
import dataService.DataFactoryService.DataFactoryService;
import dataService.UserdataService.UserdataService;
import init.Client;
import businessLogicService.UserblService.UserblService;
import vo.Authorities;
import vo.UserVO;

<<<<<<< HEAD:Client/src/main/java/businessLogic/Userbl/User.java
public class User implements UserblService{
	
	private DataFactoryService dataFactory;
	private UserdataService userdata;
	
	public User(){
	    	dataFactory=Client.dataFactory;
			userdata=dataFactory.getUserdataService();
	}	
	
=======
public class Userbl implements UserblService{

	public Userbl(){
		
	}
>>>>>>> origin/master:Client/src/main/java/businessLogic/Userbl/Userbl.java
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

}
