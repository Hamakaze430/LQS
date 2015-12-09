package businessLogic.Userbl;

import po.UserPO;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Authorities;
import businessLogicService.UserblService.ApartmentManagerblService;
import businessLogicService.UserblService.AuthoritiesSettingblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import vo.UserVO;
/**
 * 用户管理的逻辑
 */
public class UserManagerbl implements UserManagerblService{
	
	private DataFactoryService dataFactory;
	private ApartmentManagerblService apartmentbl;
	public UserManagerbl(){
	    	dataFactory=Client.dataFactory;
			apartmentbl = new ApartmentManagerbl();
	}
	
	public UserVO findUser(String userID) {
		UserPO po = dataFactory.getUserdataService().getUserbyID(userID);
		if (po == null) return null;
		String hallName = apartmentbl.getName(po.getHallId());
		return new UserVO(po.getID(),po.getPassword(),po.getAuthority(),po.getName(),po.getSex(),po.getJob(),hallName);
	}

	public boolean addUser(UserVO vo) {
		String hallId = apartmentbl.getId(vo.getHall());
		UserPO po=new UserPO(vo.getID(),vo.getPassword(),vo.getAuthority(),vo.getName(),vo.getSex(),vo.getJob(),hallId);
		return dataFactory.getUserdataService().addUser(po);
	}

	public boolean update(UserVO vo) {
		String hallId = apartmentbl.getId(vo.getHall());
		UserPO po=new UserPO(vo.getID(),vo.getPassword(),vo.getAuthority(),vo.getName(),vo.getSex(),vo.getJob(),hallId);
		return dataFactory.getUserdataService().updateUser(po);
	}

	public boolean delete(UserVO vo) {
		String hallId = apartmentbl.getId(vo.getHall());
		UserPO po=new UserPO(vo.getID(),vo.getPassword(),vo.getAuthority(),vo.getName(),vo.getSex(),vo.getJob(),hallId);
		return dataFactory.getUserdataService().deleteUser(po);
	}

	public List<UserVO> getAll() {
		List<UserPO> list = dataFactory.getUserdataService().getAllUsers();
		List<UserVO> ans = new ArrayList<UserVO>();
		for (UserPO po : list){
			String hallName = apartmentbl.getName(po.getHallId());
			ans.add(new UserVO(po.getID(),po.getPassword(),po.getAuthority(),po.getName(),po.getSex(),po.getJob(),hallName));
		}
		return ans;
	}

	public int getCount(String id) {
		int count = 0;
		List<UserPO> list = dataFactory.getUserdataService().getAllUsers();
		for (UserPO po : list){
			if (!po.getID().equals("admin")){
				if (po.getID().substring(0, 8).equals(id)) count++;
			}
		}
		return count;
	}

}
