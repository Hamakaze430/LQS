package dataService.UserdataService;

import java.rmi.Remote;
import java.util.List;

import Miscellaneous.Place;
import po.HallPO;

public interface ApartmentDataService extends Remote {

	public List<HallPO> findAll();

	public boolean insert(HallPO po);

	public int getNum(String s, Place place);

	public boolean addNum(String text, Place place);

	public boolean delete(HallPO po);

	public boolean decNum(String type, Place place);

	public boolean update(HallPO po);

}
