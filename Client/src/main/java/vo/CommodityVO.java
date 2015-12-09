package vo;

import po.CommodityPO;

/**
 * Created by admin on 15/10/25.
 */
public class CommodityVO {
	private String id;
	private String dateofin;
	private String specie;
	private String location;
	private String price;
	
	public CommodityVO(CommodityPO po){
		id=po.getID();
		dateofin=po.getDateOfIn();
		specie=po.getSpecie();
		location=po.getLocation();
		price=po.getPrice();
	}
	
}
