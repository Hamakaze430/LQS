package businessLogic.Commoditybl;

import java.util.ArrayList;

import vo.receipts.ArriveReceiptVO;
import vo.receipts.TransferReceiptVO;

public interface StationInfo {
	
    public ArrayList<ArriveReceiptVO> viewApproveArrive(String comID);
	
	public ArrayList<TransferReceiptVO> viewApproveTransfer(String comID);
}
