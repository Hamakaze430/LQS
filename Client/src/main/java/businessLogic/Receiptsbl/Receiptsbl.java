package businessLogic.Receiptsbl;

import businessLogicService.ReceiptsblService.ReceiptsblService;
import dataService.dataFactoryService.DataFactoryService;
import init.RMIHelper;

public class Receiptsbl implements ReceiptsblService {
	
<<<<<<< HEAD
	
	public String showVouchers() {
		return null;
	}
	
	public double getPrice() {
		return 0;
	}

=======
	private DataFactoryService df;
	public Receiptsbl(){
		df = RMIHelper.getDataFactory();
	}
	public String getLoadingId() {
		// TODO Auto-generated method stub
		return null;
	}
	
>>>>>>> origin/master
}
