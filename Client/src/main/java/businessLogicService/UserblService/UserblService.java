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
	
	public String getUserPassword();

	public boolean changePassword(String valueOf);

	public String getHallType();

	public String getHallPlace();
<<<<<<< HEAD

	public String getCenterName();

=======

	public UserVO findUser(String known, String info);

>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
}
