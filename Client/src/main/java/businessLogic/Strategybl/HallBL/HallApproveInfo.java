package businessLogic.Strategybl.HallBL;

import java.util.ArrayList;

import vo.receipts.ArrivalReceiptVO;
import vo.receipts.DeliverReceiptVO;
import vo.receipts.HallTransferReceiptVO;

public interface HallApproveInfo {

	
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceiptSubmitted();
	
	public void approveArrivalReceipt(String id);
	
	public ArrayList<ArrivalReceiptVO> viewAllArrivalReceipt();
	
    public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceiptSubmitted();
	
	public void approveHallTransferReceipt(String id);
	
	public ArrayList<HallTransferReceiptVO> viewAllHallTransferReceipt();
	
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceiptSubmitted();
	
	public void approveDeliverReceipt(String id);
	
	public ArrayList<DeliverReceiptVO> viewAllDeliverReceipt();
	
}
