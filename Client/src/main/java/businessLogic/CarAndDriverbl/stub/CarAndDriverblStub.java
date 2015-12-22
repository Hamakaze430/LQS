package businessLogic.CarAndDriverbl.stub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessLogicService.CarAndDriverblService.CarAndDriverblService;
import vo.CarVO;
import vo.DriverVO;

public class CarAndDriverblStub implements CarAndDriverblService {

	public CarVO findCarInfo(String id) {
		if (id.equals("025000010")){
		 CarVO car = new CarVO("025000010", "苏A 00000", "2015/06/03");
		 return car;
		}
		return null;
	}

	public DriverVO findDriverInfo(String id) {
		// TODO Auto-generated method stub
		if (id.equals("025000010")){
			 //姓名、出生日期、身份证号、手机 、性别、行驶证期限
			 DriverVO driver = new DriverVO("025000010", "李晓华", "1996/11/10", "330382199701014526", "15651726589", "女", "2016/12/31");
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

	public List<CarVO> findAllCarInfo(String hallId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addCarInfo(String date, CarVO car) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getLastId(String type, String foreId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean find(String type, String known) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<DriverVO> findAllDriverInfo(String hallId) {
		// TODO Auto-generated method stub
		return null;
	}

}
