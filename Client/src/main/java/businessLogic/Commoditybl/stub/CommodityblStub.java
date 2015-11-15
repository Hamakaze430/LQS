package businessLogic.Commoditybl.stub;

public interface CommodityblService_Stud implements CommodityblService{
	int commodityid;
	String commoditydateofin;
	String commodityspecie;
	String commoditylocation;
	String commodityprice;
	
	public CommodityVO getCommodityByID(int commodityid){
		return new CommodityVO(commoditydateofin,commodityspecie,commoditylocation,commodityprice);
	}
	
	public ResultMessage addCommodity(int commodityid){
		if(commodityid == 0000000001)
			return ResultMessage.Exist;
		else return ResultMessage.NotExist;
	}
	
	public String getCommodityDateOfIn(int commodityid){
		return commoditydateofin;
	}
	
	public String getCommoditySpecie(int commodityid){
		return commodityspecie;
	}
	
	public String getCommodityLocation(int commodityid){
		return commoditylocation;
	}

	public String getCommodityPrice(int commodityid){
		return commoditylocation;
	}
	
	public class CommodityView{
		
	}
}
