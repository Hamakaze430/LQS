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
	
	/*
	 * 想View传递VO
	 * */
	public SalesVO show();

	/*
	 * 从Data生成报表
	 * */
    public boolean getReport();
    
    /*
	 * 将PO序列化并存入数据层
	 * */
    public void save(SalesPO sales);

    
    /*
	 * 取消导出报表
	 * */
    public String cancelReport();

    /*
	 * 退出Sales界面
	 * */
    public void exit();
}
