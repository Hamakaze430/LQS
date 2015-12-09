package data.Commoditydata;

import java.util.ArrayList;

import po.ComGoodsPO;
import po.ComInfoPO;

public interface ComInfoDAO {

	public void add(ComInfoPO po);
	public void remove(String comID);
	public void modify(String comID, ComInfoPO po);
	public ComInfoPO find(String comID);
	public ArrayList<ComInfoPO> getAll();
	//public void modifyZone(ComZonePO po);
	public String nextID();
	
	public void addGoods(String comID, ArrayList<ComGoodsPO> list);
	public void removeGoods(String comID, ArrayList<ComGoodsPO> list);
	
}