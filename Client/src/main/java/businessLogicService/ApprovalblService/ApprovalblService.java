package businessLogicService.ApprovalblService;

import java.util.List;

import po.ApprovalPO;
import vo.ApprovalVO;

public interface ApprovalblService {

	public boolean insert(ApprovalPO po);
<<<<<<< HEAD

	public List<ApprovalVO> findAll();
=======

	public List<ApprovalVO> findAll();

	public boolean getPassed(ApprovalVO vo);
>>>>>>> 1308c02f8ef1117282572129df3883e55e37571b

}
