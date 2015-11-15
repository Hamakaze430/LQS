package businessLogic.Receiptsbl;

import businessLogicService.ReceiptsblService.ReceiptsblService;
import dataService.dataFactoryService.DataFactoryService;
import init.RMIHelper;

public class Receiptsbl implements ReceiptsblService {
	
	private DataFactoryService df;
	public Receiptsbl(){
		df = RMIHelper.getDataFactory();
	}
	public String getLoadingId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
