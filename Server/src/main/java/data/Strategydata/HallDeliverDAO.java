package data.Strategydata;

import java.util.ArrayList;

import Miscellaneous.ResultMessage;
import po.receipts.DeliverReceiptPO;

public interface HallDeliverDAO {

	public ResultMessage insert(DeliverReceiptPO po);
	public ResultMessage delete(String id);
	public DeliverReceiptPO find(String id);
	public ArrayList<DeliverReceiptPO> getAll();
	public ArrayList<DeliverReceiptPO> showAll();
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list);
	public void flush();
}