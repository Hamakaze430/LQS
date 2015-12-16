package businessLogic.Userbl;

import po.UserPO;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Authorities;
import Miscellaneous.Place;
import businessLogicService.UserblService.ApartmentManagerblService;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.AuthoritiesSettingblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import vo.HallVO;
import vo.UserVO;
/**
 * 登录后用户信息的获取
 */
public class Userbl implements UserblService{
	
	private DataFactoryService dataFactory;
	private ApartmentblService apartmentbl;
	private UserVO info;
	private HallVO hall;
	
	public Userbl(String userID){
    	dataFactory=Client.dataFactory;
		apartmentbl = new Apartmentbl();
		this.info = findUser(userID);
		this.hall = getHallVO(info.getHall());
		if (info == null) info = new UserVO("","","","","","","");
	}

	private HallVO getHallVO(String hall2) {
		return apartmentbl.getVOByName(info.getHall());
	}

	public UserVO findUser(String userID) {
		UserPO po = dataFactory.getUserdataService().getUserbyID(userID);
		if (po == null) return null;
		String hallName = apartmentbl.getName(po.getHallId());
		return new UserVO(po.getID(),po.getPassword(),po.getAuthority(),po.getName(),po.getSex(),po.getJob(),hallName);
	}

	public String getHallId() {
		// TODO Auto-generated method stub
		return hall.getID();
	}

	public String getHallName() {
		// TODO Auto-generated method stub
		return hall.getName();
	}
	
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return info.getPassword();
	}

	public boolean hasTheAuthority(Authorities one) {
		AuthoritiesSettingblService bl = new AuthoritiesSettingbl();
		return bl.hasTheAuthority(info.getAuthority(), one);
		
	}

	public String getUserName() {
		return info.getName();
	}

	public String getUserSex() {
		// TODO Auto-generated method stub
		return info.getSex();
	}

	public String getCompanyName() {
		return info.getHall();
	}

	public boolean changePassword(String s) {
		// TODO Auto-generated method stub
		UserManagerblService bl = new UserManagerbl();
		info.setPassword(s);
		return bl.update(info);
	}

	public String getHallType() {
		String s = hall.getID();
		if (s.length() == 4) return "中转中心";
		else return "营业厅";
	}

	public String getHallPlace() {
		String s = hall.getLocation();
		for (Place p : Place.values()){
			if (s.substring(0, 3).equals(p.name())) return p.name();
		}
		return "";
	}

}
