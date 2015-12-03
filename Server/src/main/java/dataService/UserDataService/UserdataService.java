package dataService.UserdataService;

import po.*;

public interface UserdataService {

	public UserPO getCurrentUser();
	
	public UserPO getUserbyID(String ID);
	
	public void addUser(UserPO user);
}
