package businessLogicService.SalesblService;

import po.SalesPO;
import vo.SalesVO;

public interface SalesblService {

//    public String getStartDate();
//
//    public String getEndDate();

//    public Boolean checkDate(String start, String end);
//
//    public String showOut(String start, String end);
//
//    public String showIn(String start, String end);
	
	public SalesVO show();

    public void getReport();
    
    public void save(SalesPO sales);

    public String cancelReport();

    public void exit();
}
