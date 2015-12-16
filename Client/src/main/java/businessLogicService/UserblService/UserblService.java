package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Authorities;
import vo.UserVO;

public interface UserblService {

	public String getHallId();

	public String getHallName();

	public boolean hasTheAuthority(Authorities one);

	public String getUserName();

	public String getUserSex();

	public String getCompanyName();
	
	public UserVO findUser(String userID);
	
	public String getUserPassword();

	public boolean changePassword(String valueOf);

<<<<<<< HEAD
	public String getHallType();

	public String getHallPlace();
=======
	public String getCenterName();

>>>>>>> 3888cb0f59604d864ef3e86d350a6682cc41b907
}
