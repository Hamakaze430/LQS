package businessLogicService.LogisticsInfoSearchblService;

import po.ReceiptPO;
import vo.LogisticsVO;
import vo.ReceiptVO;

public interface LogisticsInfoSearchblService {
	/**
	 * 查询对应订单的物流信息
	 * @param id
	 * @return
	 */
	public LogisticsVO search(String id);

	public void newLogisticsInfo(ReceiptVO vo);

	public void addState(ReceiptVO vo);
}
