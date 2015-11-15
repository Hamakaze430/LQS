package businessLogic.VoucherSearchbl;

import businessLogicService.VoucherSearchblService.VoucherSearchblService;

public class VoucherSearchController implements VoucherSearchblService {
	
	VoucherSearchblService vouchersearchblservice;
	
	public  VoucherSearchController(VoucherSearchblService vouchersearchblservice){
		this.vouchersearchblservice=vouchersearchblservice;
	}
	
	
	

}
