package businessLogic.Userbl;

import vo.UserVO;
import businessLogicService.UserblService.UserblService;

public class Userbl implements UserblService{
	public boolean login(long id,String password){
		return true;
	}
	public boolean viewOrgazation(){
		return true;
	}
	public boolean addUser(UserVO user){
		return true;
		
	}
	
	public boolean deleteUser(UserVO user){
		return true;
	}
	
	public boolean changeUser(UserVO user){
		return true;
	}
	
	public boolean addHall(UserVO user){
		return true;
		
	}
	public boolean deleteHall(UserVO user){
		return true;
		
	}
	public boolean changeHall(UserVO user){
		return true;
		
	}
	public boolean addCenter(UserVO user){
		return true;
		
	}
	public boolean deleteCenter(UserVO user){
		return true;
		
	}
	public boolean changeCenter(UserVO user){
		return true;
		
	}
	
	
	
	
	

}
