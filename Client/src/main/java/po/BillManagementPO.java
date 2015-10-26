package po;

import vo.*;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class BillManagementPO implements Serializable {
    String date;
    String name;
    UserVO users;
    CarVO cars;
    DriverVO drivers;
    CommodityVO storage;
    BankAccountVO account;

    public String getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public UserVO getWorkers(){
        return users;
    }

    public CarVO getCars(){
        return cars;
    }

    public DriverVO getDrivers(){
        return drivers;
    }

    public CommodityVO getStorage(){
        return storage;
    }

    public BankAccountVO getAccountInfo(){
        return account;
    }
}
