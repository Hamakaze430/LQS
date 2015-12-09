package businessLogic.Strategybl.Stationbl;

import java.util.ArrayList;

import dataService.ResultMessage;
import vo.receipts.ArriveReceiptVO;
import vo.receipts.TransferReceiptVO;

public interface StationApproveInfo {

	public ArrayList<ArriveReceiptVO> viewAllArriveReceiptSubmitted();
	
	public ResultMessage approveArriveReceipt(String id);
	
	public ArrayList<ArriveReceiptVO> viewAllArriveReceipt();
	
	public ArrayList<TransferReceiptVO> viewAllTransferReceiptSubmitted();
	
	public ResultMessage approveTransferReceipt(String id);
	
	public ArrayList<TransferReceiptVO> viewAllTransferReceipt();
}
