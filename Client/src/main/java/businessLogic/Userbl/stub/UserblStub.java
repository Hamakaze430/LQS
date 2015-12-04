package businessLogic.Userbl.stub;

import vo.Authorities;
import vo.UserVO;
import businessLogicService.UserblService.UserblService;

public class UserblStub implements UserblService{
	int userid=0;
	String userpassword="";
	String userpersonalinfo="";
	String usercompetence="";
	
	public class UserView{
		
	}

	public boolean addUser(UserVO user) {
		// TODO Auto-generated method stub
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
	//if (one == Authorities.寄件单) return true;
		return true;
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
