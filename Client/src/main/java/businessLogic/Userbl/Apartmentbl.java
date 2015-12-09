package businessLogic.Userbl;

import businessLogicService.UserblService.ApartmentblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.HallPO;

public class Apartmentbl implements ApartmentblService {
	
private DataFactoryService dataFactory;
	
	public Apartmentbl(){
		dataFactory = Client.dataFactory;
	}
	/**
	 * 
	 */
	public String getId(String hallName) {
		HallPO po = dataFactory.getApartmentDataService().find("Name",hallName);
		return po.getID();
	}
	/**
	 * 
	 */
	public String getName(String hallId) {
		HallPO po = dataFactory.getApartmentDataService().find("Id",hallId);
		return po.getName();
	}
}
