package dataService.ReceiptsdataService;

import java.util.ArrayList;

import po.ReceiptPO;

public interface ReceiptsdataService {

	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date);
}
