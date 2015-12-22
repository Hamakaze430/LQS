package businessLogic.CarAndDriverbl;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.CarAndDriverPO;
import po.CarPO;
import po.DriverPO;
import vo.CarVO;
import vo.DriverVO;

public class CarAndDriverbl implements CarAndDriverblService {
	private DataFactoryService dataFactory;
	
	public CarAndDriverbl(){
		dataFactory = Client.dataFactory;
	}

	public boolean addCarInfo(String date,CarVO car) {
		// TODO Auto-generated method stub
		CarPO po= new CarPO(car.getId(),car.getLicense(),date);
		return dataFactory.getCarAndDriverdataService().insert("car",po);
	}

	public boolean addDriverInfo(DriverVO driver) {
		DriverPO po= new DriverPO(driver.getId(),driver.getName(),driver.getBirth(),driver.getIdentity(),driver.getMobile(),driver.getGender(),driver.getTime());
		return dataFactory.getCarAndDriverdataService().insert("driver",po);
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


	public List<CarVO> findAllCarInfo(String hallId) {
		List<CarAndDriverPO> list = dataFactory.getCarAndDriverdataService().findAll("car","hallId",hallId);
		List<CarVO> ans = new ArrayList<CarVO>();
		for (CarAndDriverPO po : list){
			CarVO vo = new CarVO((CarPO)po);
			ans.add(vo);
		}
		return ans;
		
	}

	public List<DriverVO> findAllDriverInfo(String hallId) {
		List<CarAndDriverPO> list = dataFactory.getCarAndDriverdataService().findAll("driver","hallId",hallId);
		List<DriverVO> ans = new ArrayList<DriverVO>();
		for (CarAndDriverPO po : list){
			DriverVO vo = new DriverVO((DriverPO)po);
			ans.add(vo);
		}
		return ans;
	}


	public boolean deleteCarInfo(CarVO vo) {
		return dataFactory.getCarAndDriverdataService().delete("car",vo.getId());
	}


	public boolean deleteDriverInfo(DriverVO vo) {
		return dataFactory.getCarAndDriverdataService().delete("driver",vo.getId());
	}

}
