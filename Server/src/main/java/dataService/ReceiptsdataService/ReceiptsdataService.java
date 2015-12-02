package dataService.ReceiptsdataService;

import java.util.ArrayList;

import data.Receiptsdata.*;
import po.ReceiptPO;
import po.receipts.*;

public interface ReceiptsdataService {

	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date);
	
	public ArrayList<PaymentPO> getPaymentBeforeDate(String date);
	
	public ArrayList<IncomePO> getIncomeBeforeDate(String date);
}
