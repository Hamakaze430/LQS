package dataService.CarAndDriverdataService;

import java.rmi.Remote;
import java.util.List;

import po.CarAndDriverPO;

public interface CarAndDriverdataService extends Remote {

    public String get();

	public boolean insert(String type, CarAndDriverPO po);
	
	public List<CarAndDriverPO> findAll(String type);

	public int getCount(String type, String foreId);

	public boolean find(String type, String known);
}
