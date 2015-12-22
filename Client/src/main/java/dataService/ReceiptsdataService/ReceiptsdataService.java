package dataService.ReceiptsdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import po.receipts.IncomePO;
import po.receipts.PaymentPO;

public interface ReceiptsdataService extends Remote {

    public String getReceipt(String type);

	public long getLastId(String foreId);

	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date);
	
	public ArrayList<PaymentPO> getPaymentBeforeDate(String date);
	
	public ArrayList<IncomePO> getIncomeBeforeDate(String date);

	public boolean insert(ReceiptPO po);

	public long addReceiptId();

	public ReceiptPO find(String known, String info);
	
}
