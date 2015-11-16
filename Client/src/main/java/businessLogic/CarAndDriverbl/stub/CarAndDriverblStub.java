package businessLogic.CarAndDriverbl.stub;

import java.util.ArrayList;
import java.util.Date;

import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import vo.CarVO;
import vo.DriverVO;

public class CarAndDriverblStub implements CarAndDriverblService {

	public CarVO findCarInfo(String id) {
		if (id.equals("025000010")){
		 Date time = new Date(20150603);
		 CarVO car = new CarVO("025000010", "苏A 00000", time);
		 return car;
		}
		return null;
	}

	public DriverVO findDriverInfo(String id) {
		// TODO Auto-generated method stub
		if (id.equals("025000010")){
			 Date birth = new Date(19961110);
			 Date time = new Date(20161231);
			 //姓名、出生日期、身份证号、手机 、性别、行驶证期限
			 DriverVO driver = new DriverVO("025000010", "李晓华", birth, "330382199701014526", "15651726589", "女", time);
			 return driver;
			}
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
		return true;
	}

	public boolean addDriverInfo(DriverVO driver) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean deleteCarInfo(CarVO car) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean deleteDriverInfo(DriverVO driver) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<String> findAllCarInfo(String hallId) {
		// TODO Auto-generated method stub
		return null;
	}

}
