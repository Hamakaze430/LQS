package businessLogicService.ApprovalblService;

import java.util.List;

import po.ApprovalPO;
import vo.ApprovalVO;

public interface ApprovalblService {

	public boolean insert(ApprovalPO po);

	public List<ApprovalVO> findAll();

	public boolean getPassed(ApprovalVO vo);

}
