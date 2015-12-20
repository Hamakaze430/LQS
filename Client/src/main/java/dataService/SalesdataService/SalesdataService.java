package dataService.SalesdataService;

import java.rmi.Remote;

import po.*;

public interface SalesdataService extends Remote {

	public void save(SalesPO sales);

	public SalesPO getSales(String start, String end);
	
	public boolean getReport(SalesPO sales);
	
}
