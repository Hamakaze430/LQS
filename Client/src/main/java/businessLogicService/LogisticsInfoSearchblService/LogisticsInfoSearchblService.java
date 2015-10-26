package businessLogicService.LogisticsInfoSearchblService;

import vo.LogisticsVO;

public interface LogisticsInfoSearchblService {
	/**
	 * 查询对应订单的物流信息
	 * @param id
	 * @return
	 */
	public LogisticsVO search(String id);
}
