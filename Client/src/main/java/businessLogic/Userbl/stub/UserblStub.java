package businessLogic.Userbl.stub;

import vo.UserVO;

import java.util.List;

import Miscellaneous.Authorities;
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
		if (one == Authorities.用户管理) return true;
		if (one == Authorities.部门管理) return true;
		//if (one == Authorities.收款单查询) return true;
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

	public boolean update(UserVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(UserVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
