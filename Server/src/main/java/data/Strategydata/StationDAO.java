package data.Strategydata;

import java.util.ArrayList;

import po.StationPO;
import po.receipts.ArriveReceiptPO;
import po.receipts.TransferReceiptPO;

public interface StationDAO {
	
	public void addStation(String id, String location);
	public void removeStation(String id);
	public ArrayList<StationPO> showStation();
	
	public void addArriveReceipt(ArriveReceiptPO po, String stationID);
	public ArrayList<ArriveReceiptPO> getArriveReceipt(String stationID);
	public void approveArriveReceipt(ArrayList<ArriveReceiptPO> list);
	public void modifyArriveReceipt(String id, ArriveReceiptPO po);
	
	public void addTransferReceipt(TransferReceiptPO po, String stationID) ;
	public ArrayList<TransferReceiptPO> getTransferReceipt(String stationID);
	public void approveTransferReceiptPO(ArrayList<TransferReceiptPO> list);
	public void modifyTransferReceiptPO(String id, TransferReceiptPO po);

}
