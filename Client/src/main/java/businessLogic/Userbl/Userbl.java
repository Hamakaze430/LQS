package businessLogic.Userbl;

import po.UserPO;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Authorities;
import businessLogicService.UserblService.ApartmentManagerblService;
import businessLogicService.UserblService.ApartmentblService;
import businessLogicService.UserblService.AuthoritiesSettingblService;
import businessLogicService.UserblService.UserManagerblService;
import businessLogicService.UserblService.UserblService;
import vo.UserVO;
/**
 * 登录后用户信息的获取
 */
public class Userbl implements UserblService{
	
	private DataFactoryService dataFactory;
	private ApartmentblService apartmentbl;
	private UserVO info;
	public Userbl(){
		
	}
	
	public Userbl(String userID){
    	dataFactory=Client.dataFactory;
		apartmentbl = new Apartmentbl();
		this.info = findUser(userID);
		if (info == null) info = new UserVO("","","","","","","");
	}

	public UserVO findUser(String userID) {
		UserPO po = dataFactory.getUserdataService().getUserbyID(userID);
		if (po == null) return null;
		String hallName = apartmentbl.getName(po.getHallId());
		return new UserVO(po.getID(),po.getPassword(),po.getAuthority(),po.getName(),po.getSex(),po.getJob(),hallName);
	}

	public String getHallId() {
		// TODO Auto-generated method stub
		return apartmentbl.getId(info.getHall());
	}

	public String getHallName() {
		// TODO Auto-generated method stub
		return info.getHall();
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

	public String getCenterName() {
		// TODO Auto-generated method stub
		return null;
	}

}
