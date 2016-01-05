package data.Commoditydata;

import java.util.ArrayList;

import po.receipts.StorageInReceiptPO;
import Common.CommonData;
import Miscellaneous.ReceiptState;
import Miscellaneous.ResultMessage;

public class StorageInFileDAO extends CommonData<StorageInReceiptPO> implements StorageInReceiptDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageInFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	
	public void add(StorageInReceiptPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}
	
	
	public ArrayList<StorageInReceiptPO> showAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

	
	public ArrayList<StorageInReceiptPO> showAllReceipt(String comID) {
		// TODO Auto-generated method stub
		ArrayList<StorageInReceiptPO> list = showAll();
		ArrayList<StorageInReceiptPO> newlist = new ArrayList<StorageInReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getID().contains(comID))
				newlist.add(list.get(i));
		return newlist;
	}

	
	public ArrayList<StorageInReceiptPO> showAllSummit() {
		// TODO Auto-generated method stub
		ArrayList<StorageInReceiptPO> list = this.showAll();
		ArrayList<StorageInReceiptPO> newlist = new ArrayList<StorageInReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.未审批)
				newlist.add(list.get(i));
		return newlist;
	}

	
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		StorageInReceiptPO po = find(id);
		po.approve();
		return update(id,po);
	}

	
	public String nextID(String comID) {
		// TODO Auto-generated method stub
		ArrayList<StorageInReceiptPO> list = showAllReceipt(comID);
		String id = list.get(list.size()-1).getID();
		String nextID = Integer.parseInt(id.substring(12, id.length()))+1+"";
		return nextID;
	}

}
