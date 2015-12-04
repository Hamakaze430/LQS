package dataService.SalesdataService;

import po.*;

public interface SalesdataService {

	public void save(SalesPO sales);
	
	public SalesPO getSales(String start, String end);
	
	public SalesPO getReport();
}
