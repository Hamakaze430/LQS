package businessLogicService.VoucherSearchblService;

import java.util.ArrayList;
import vo.receipts.*;

public interface VoucherSearchblService {

	public ArrayList<IncomeVO> getbyDate(String date);

	public ArrayList<IncomeVO> getbyHall(String hall);

}
