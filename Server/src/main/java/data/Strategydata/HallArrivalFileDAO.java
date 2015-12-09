package data.Strategydata;

import java.util.ArrayList;

import po.receipts.ArrivalReceiptPO;
import Common.CommonData;

public class HallArrivalFileDAO extends CommonData<ArrivalReceiptPO> implements HallArrivalDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallArrivalFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void approveArrivalReceipt(ArrayList<ArrivalReceiptPO> list) {
		// TODO Auto-generated method stub
		for(ArrivalReceiptPO arrivalpo:list){
			arrivalpo.approve();
		}
	}
}
