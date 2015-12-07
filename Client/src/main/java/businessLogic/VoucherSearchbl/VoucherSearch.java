package businessLogic.VoucherSearchbl;

import init.Client;

import java.util.ArrayList;

import dataService.VoucherSearchdataService.VoucherSearchdataService;
import vo.receipts.IncomeVO;
import businessLogicService.VoucherSearchblService.VoucherSearchblService;

public class VoucherSearch implements VoucherSearchblService {

	private VoucherSearchdataService voucher;
	
	public VoucherSearch(){
		voucher=Client.dataFactory.getVoucherSearchdataService();
	}
	
	public ArrayList<IncomeVO> getbyDate(String date) {
		// TODO Auto-generated method stub
		return voucher.getbyDate(date);
	}

	public ArrayList<IncomeVO> getbyHall(String hall) {
		// TODO Auto-generated method stub
		return voucher.getbyHall(hall);
	}

}
