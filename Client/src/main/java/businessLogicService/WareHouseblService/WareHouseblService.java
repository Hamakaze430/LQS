package businessLogicService.WareHouseblService;

import vo.RowVO;

public interface WareHouseblService {
	
	public void setCapacity(int number);
	
	public void changeDivision(RowVO row);
	
	public void CapacityWarning();

}
