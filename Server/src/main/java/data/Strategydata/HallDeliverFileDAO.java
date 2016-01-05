package data.Strategydata;

import java.util.ArrayList;

import po.receipts.DeliverReceiptPO;
import Common.CommonData;

public class HallDeliverFileDAO extends CommonData<DeliverReceiptPO> implements HallDeliverDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HallDeliverFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}


	
	public void approveDeliverReceipt(ArrayList<DeliverReceiptPO> list) {
		// TODO Auto-generated method stub
		for(DeliverReceiptPO deliverpo:list){
			deliverpo.approve();
		}
	}

	

}

