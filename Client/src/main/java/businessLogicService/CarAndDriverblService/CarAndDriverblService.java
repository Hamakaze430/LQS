package businessLogicService.CarAndDriverblService;

import vo.CarVO;
import vo.DriverVO;

public interface CarAndDriverblService {
	/**
	 * 获取车辆信息
	 * @param id  车辆代号
	 * @return 车辆信息
	 */
	public CarVO findCarInfo(String id);
	
	/**
	 * 获取司机信息 
	 * @param id 司机编号
	 * @return 司机信息
	 */
	public DriverVO findDriverInfo(String id);
	
	/**更新车辆信息
	 * @param car
	 * @return
	 */
	public boolean updateCarInfo(CarVO car);
	
	/**更新司机信息
	 * @param driver
	 * @return
	 */
	public boolean updateDriverInfo(DriverVO driver);
	
	/**
	 * 新增车辆信息
	 * @param car
	 * @return
	 */
	public boolean addCarInfo(CarVO car);
	
	/**
	 * 新增司机信息
	 * @param driver
	 * @return
	 */
	public boolean addDriverInfo(DriverVO driver);
	
	/**
	 * 删除车辆信息
	 * @param car
	 * @return
	 */
	public boolean deleteCarInfo(CarVO car);
	
	
	/**
	 * 删除司机信息
	 * @param driver
	 * @return
	 */
	public boolean deleteDriverInfo(DriverVO driver);
	
	
}
