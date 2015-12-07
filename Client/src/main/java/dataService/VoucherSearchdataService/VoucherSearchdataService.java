package dataService.VoucherSearchdataService;

import java.rmi.Remote;
import java.util.ArrayList;

import vo.receipts.IncomeVO;

public interface VoucherSearchdataService extends Remote {

	public ArrayList<IncomeVO> getbyDate(String date);

	public ArrayList<IncomeVO> getbyHall(String hall);
	
}
