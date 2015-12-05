package businessLogicService.StrategyblService;

import vo.ConstantVO;
import dataService.ResultMessage;

public interface ConstantblService {
		public ResultMessage setDistance(String id1, String id2, double distance);
	
		public ResultMessage setPrice(double p);
		
		public ResultMessage setVehicleCost(double van,double railway,double airplane);
		
		public ResultMessage setVehicleLoad(int van, int railway, int airplane);

		public ConstantVO getConstant();

}
