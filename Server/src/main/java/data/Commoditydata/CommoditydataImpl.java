package data.Commoditydata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import po.CommodityPO;
import dataService.CommoditydataService.CommoditydataService;

public class CommoditydataImpl implements CommoditydataService{

	public ArrayList<CommodityPO> getAllCommodity() {
		ArrayList<CommodityPO> list=new ArrayList<CommodityPO>();
		try {
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("src/main/java/ser/commodity.ser"));
			CommodityPO temp;
			while((temp=(CommodityPO)in.readObject())!=null){
				list.add(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
