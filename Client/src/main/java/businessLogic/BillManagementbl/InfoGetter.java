package businessLogic.BillManagementbl;
import po.*;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by admin on 15/11/15.
 */

public class InfoGetter {

    public String getDate(){
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DATE);
        String date=String.valueOf(year)+String.valueOf(month)+String.valueOf(day);
        return date;
    }

    public String getName(){

    }

    public UserPO getWorkers(){

    }

    public CarPO getCars(){

    }

    public CommodityPO getStorage(){

    }

    public BankAccountPO getAccount(){

    }
}
