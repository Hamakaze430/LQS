package businessLogic.CarAndDriverbl;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.CarPO;
import po.DriverPO;
import vo.CarVO;
import vo.DriverVO;

public class CarAndDriverbl implements CarAndDriverblService {
	private DataFactoryService dataFactory;
	
	public CarAndDriverbl(){
		dataFactory = Client.dataFactory;
	}

	public CarVO findCarInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverVO findDriverInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCarInfo(CarVO car) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean updateDriverInfo(DriverVO driver) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean addCarInfo(CarVO car) {
		// TODO Auto-generated method stub
		CarPO po= new CarPO(car.getId(),car.getLicense(),car.getTime());
		return dataFactory.getCarAndDriverdataService().insert("car",po);
	}

	public boolean addDriverInfo(DriverVO driver) {
		DriverPO po= new DriverPO(driver.getId(),driver.getName(),driver.getBirth(),driver.getIdentity(),driver.getMobile(),driver.getGender(),driver.getTime());
		return dataFactory.getCarAndDriverdataService().insert("driver",po);
	}

	public boolean deleteCarInfo(CarVO car) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteDriverInfo(DriverVO driver) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CarVO> findAllCarInfo(String hallId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DriverVO> findAllDriverInfo(String hallId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int getCount(String type, String foreId) {
		return dataFactory.getCarAndDriverdataService().getCount(type,foreId);
	}
	
	public String getLastId(String type, String foreId){
		int ans = getCount(type, foreId);
		return String.format("%03d", ans);
		
	}

	public boolean find(String type, String known) {
		return dataFactory.getCarAndDriverdataService().find(type,known);
	}

}
