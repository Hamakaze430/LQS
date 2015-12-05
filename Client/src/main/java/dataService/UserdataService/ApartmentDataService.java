package dataService.UserdataService;

import java.rmi.Remote;
import java.util.List;

import vo.Place;
import po.HallPO;

public interface ApartmentDataService extends Remote {

	public List<HallPO> findAll();

	public boolean insert(HallPO po);

	//public int getHallNum(String s, Place place);

}
