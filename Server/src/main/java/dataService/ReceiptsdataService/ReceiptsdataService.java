package dataService.ReceiptsdataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.Receiptsdata.*;
import po.ReceiptPO;
import po.receipts.*;

public interface ReceiptsdataService extends Remote {
	public String getReceipt(String type) throws RemoteException;

	public String getLastId(String foreId) throws RemoteException;
	
	public ArrayList<ReceiptPO> getReceiptBeforeDate(String date) throws RemoteException;
	
	public ArrayList<PaymentPO> getPaymentBeforeDate(String date) throws RemoteException;
	
	public ArrayList<IncomePO> getIncomeBeforeDate(String date) throws RemoteException;
	
	public boolean insert(ReceiptPO po) throws RemoteException;
	
	public long addReceiptId() throws RemoteException;
	
	public ReceiptPO find(String known, String info) throws RemoteException;
}
