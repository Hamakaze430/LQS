package businessLogic.Userbl;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.UserblService.ApartmentblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.HallPO;
import vo.HallVO;

public class Apartmentbl implements ApartmentblService {
	
private DataFactoryService dataFactory;
	
	public Apartmentbl(){
		dataFactory = Client.dataFactory;
	}
	/**
	 * 
	 */
	public String getName(String hallId) {
		HallPO po = dataFactory.getApartmentDataService().find("Id",hallId);
		return po.getName();
	}
	
	/**
	 * 根据城市名返回对应的营业厅和中转中心名字
	 */
	public List<String> getHallNameListByAddress(String hallLocation) {
		List<HallPO> list = dataFactory.getApartmentDataService().findAll("PlaceName",hallLocation);
		List<String> ans = new ArrayList<String>();
		for (HallPO po: list){
			if (po.getID().length()>3) ans.add(po.getName());
		}
		return ans;
	}
	public HallVO getVOByName(String hallName) {
		HallPO po = dataFactory.getApartmentDataService().find("Name",hallName);
		return new HallVO(po.getName(),po.getID(),po.getLocation());
	}
	public String getId(String string) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
=======
		HallPO po = dataFactory.getApartmentDataService().find("Name",string);
		return po.getID();
>>>>>>> 53bb2ae242dfc910e1ced7c53f2a8cc23ea37739
	}
}
