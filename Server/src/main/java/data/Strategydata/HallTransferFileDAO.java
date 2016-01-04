package data.Strategydata;

import java.util.ArrayList;

import Common.CommonData;
import po.receipts.HallTransferReceiptPO;

public class HallTransferFileDAO extends CommonData<HallTransferReceiptPO> implements HallTransferDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallTransferFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public void approveTransferReceipt(ArrayList<HallTransferReceiptPO> list) {
		// TODO Auto-generated method stub
		for(HallTransferReceiptPO transferpo : list){
			transferpo.approve();
		}
	}

	
}
