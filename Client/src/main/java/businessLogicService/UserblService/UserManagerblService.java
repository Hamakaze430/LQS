package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Authorities;
import vo.UserVO;

public interface UserManagerblService {
	public boolean addUser(UserVO user);

	public boolean update(UserVO vo);

	public boolean delete(UserVO vo);

	public List<UserVO> getAll();

	public int getCount(String id);
	
	public UserVO findUser(String userID);
	
	public UserVO findUserByName(String userName);
}
