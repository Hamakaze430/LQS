package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Authorities;
import vo.UserVO;

public interface UserblService {
	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	public boolean addUser(UserVO user);

	public String getHallId();

	public String getHallName();

	public boolean hasTheAuthority(Authorities one);

	public String getUserName();

	public int getUserSex();

	public String getCompanyName();

	public boolean update(UserVO vo);

	public boolean delete(UserVO vo);

	public List<UserVO> getAll();
	
	
	
	

}
