package businessLogic.BillManagementbl;

import vo.BankAccountVO;
import vo.CarVO;
import vo.CommodityVO;
import vo.UserVO;
import businessLogicService.BillManagementblService.BillManagementblService;

import java.util.*;

public class BillManagement implements BillManagementblService{
    String message;

    public String create(){
    	return "create";
    }

    public String getDate(){
    	Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        String date=String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        return date;
    }

    public String getName(){
    	
    }

    public ArrayList<UserVO> getWorkers(){
    	
    }

    public ArrayList<CarVO> getCars(){
    	
    }

    public ArrayList<CommodityVO> getStorage(){
    	
    }

    public ArrayList<BankAccountVO> getAccountInfo(){
    	
    }

    public void save(){
    	
    }

    public void check(){
    	
    }

    public void pass(){
    	
    }

    public void fail(){
    	
    }
}
