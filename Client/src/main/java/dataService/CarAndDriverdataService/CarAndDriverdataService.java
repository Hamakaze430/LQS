package dataService.CarAndDriverdataService;

import java.rmi.Remote;
import java.util.List;

import po.CarAndDriverPO;

public interface CarAndDriverdataService extends Remote {

    public String get();

	public boolean insert(String type, CarAndDriverPO po);

	public int getCount(String type, String foreId);

	public boolean find(String type, String known);

	public List<CarAndDriverPO> findAll(String type, String know, String info);
}
