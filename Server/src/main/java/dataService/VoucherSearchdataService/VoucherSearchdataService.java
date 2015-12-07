package dataService.VoucherSearchdataService;

import java.util.ArrayList;

import po.receipts.IncomePO;

public interface VoucherSearchdataService {

	public ArrayList<IncomePO> getbyDate(String date);

	public ArrayList<IncomePO> getbyHall(String hall);
}
