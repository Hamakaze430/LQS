package dataService.UserdataService;

import java.rmi.Remote;
import java.util.List;

import Miscellaneous.Place;
import po.HallPO;

public interface ApartmentDataService extends Remote {

	public List<HallPO> findAll();

	public boolean insert(HallPO po, String type);

	public int getNum(String s, String place);

	public boolean delete(HallPO po);

	public boolean decNum(String type, Place place);

	public boolean update(HallPO po);

	public HallPO find(String known, String hallInfo);

	public List<HallPO> findAll(String known, String hallInfo);

}
