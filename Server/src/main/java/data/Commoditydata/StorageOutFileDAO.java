package data.Commoditydata;

import java.util.ArrayList;

import po.receipts.StorageOutReceiptPO;
import Common.CommonData;
import Miscellaneous.ReceiptState;
import Miscellaneous.ResultMessage;

public class StorageOutFileDAO extends CommonData< StorageOutReceiptPO> implements  StorageOutReceiptDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageOutFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void add( StorageOutReceiptPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList< StorageOutReceiptPO> showAllReceipt() {
		// TODO Auto-generated method stub
		return showAll();
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList< StorageOutReceiptPO> showAllReceipt(String comID) {
		// TODO Auto-generated method stub
		ArrayList< StorageOutReceiptPO> list = showAll();
		ArrayList< StorageOutReceiptPO> newlist = new ArrayList< StorageOutReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getId().contains(comID))
				newlist.add(list.get(i));
		return newlist;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ArrayList< StorageOutReceiptPO> showAllSummit() {
		// TODO Auto-generated method stub
		ArrayList< StorageOutReceiptPO> list = this.showAll();
		ArrayList< StorageOutReceiptPO> newlist = new ArrayList< StorageOutReceiptPO>();
		for(int i=0;i<list.size();i++)
			if(list.get(i).getState()==ReceiptState.未审批)
				newlist.add(list.get(i));
		return newlist;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		 StorageOutReceiptPO po = find(id);
		po.approve();
		return update(id,po);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public String nextID(String comID) {
		// TODO Auto-generated method stub
		ArrayList< StorageOutReceiptPO> list = showAllReceipt(comID);
		String id = list.get(list.size()-1).getId();
		String nextID = Integer.parseInt(id.substring(12, id.length()))+1+"";
		return nextID;
	}

	
	
}

