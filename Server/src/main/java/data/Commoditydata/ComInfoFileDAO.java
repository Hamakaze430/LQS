package data.Commoditydata;

import java.util.ArrayList;

import po.ComGoodsPO;
import po.ComInfoPO;
import Common.CommonData;

public class ComInfoFileDAO extends CommonData<ComInfoPO> implements ComInfoDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComInfoFileDAO(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public void add(ComInfoPO po) {
		// TODO Auto-generated method stub
		insert(po);
	}

<<<<<<< HEAD

=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void remove(String comID) {
		// TODO Auto-generated method stub
		delete(comID);
	}

<<<<<<< HEAD
	
=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public void modify(String comID, ComInfoPO po) {
		// TODO Auto-generated method stub
		update(comID,po);
	}

<<<<<<< HEAD

=======
>>>>>>> 414ed55d4f228c7197815790e8c5d0e655ad716f
	public String nextID() {
		// TODO Auto-generated method stub
		ArrayList<ComInfoPO> list = this.showAll();
		String id = list.get(list.size()-1).getId();
		return id+1+"";
	}

	public void addGoods(String comID, ArrayList<ComGoodsPO> list) {
		// TODO Auto-generated method stub
		ComInfoPO po = this.find(comID);
		ArrayList<ComGoodsPO> clist = po.getComGoodsList();
		clist.addAll(list);
		this.update(comID, po);
	}

	public void removeGoods(String comID, ArrayList<ComGoodsPO> list) {
		// TODO Auto-generated method stub
		ComInfoPO po = this.find(comID);
		ArrayList<ComGoodsPO> clist = po.getComGoodsList();
		for(int i=0;i<clist.size();i++)
			for(int j=0;j<list.size();j++)
				if(clist.get(i).getId().equals(list.get(j).getId())){
					clist.remove(i);
					list.remove(j);
					i--;
					break;
				}
		update(comID,po);
	}

}
