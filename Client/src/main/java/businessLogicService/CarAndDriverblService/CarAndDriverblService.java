package businessLogicService.CarAndDriverblService;

import java.util.ArrayList;
import java.util.List;

import po.CarAndDriverPO;
import po.CarPO;
import po.DriverPO;
import vo.CarVO;
import vo.DriverVO;

public interface CarAndDriverblService {
	public boolean addCarInfo(String date,CarVO car);

	public boolean addDriverInfo(DriverVO driver);
	
	public String getLastId(String type, String foreId);

	public boolean find(String type, String known);


	public List<CarVO> findAllCarInfo(String hallId);

	public List<DriverVO> findAllDriverInfo(String hallId);

	public boolean deleteCarInfo(CarVO vo);
	
	public boolean deleteDriverInfo(DriverVO vo);
}
