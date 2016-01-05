package po;

import java.util.*;

import po.*;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class BillManagementPO implements Serializable {
    String date;
    String name;
    ArrayList<UserPO> users;
    ArrayList<CarPO> cars;
    ArrayList<DriverPO> drivers;
    ArrayList<CommodityPO> commodities;
    ArrayList<BankAccountPO> accounts;
//    UserVO users;
//    CarVO cars;
//    DriverVO drivers;
//    CommodityVO storage;
//    BankAccountVO account;

    public BillManagementPO(String date, String name, ArrayList<UserPO> u, ArrayList<CarPO> c,
                   ArrayList<DriverPO> d, ArrayList<CommodityPO> cy, ArrayList<BankAccountPO> ba){
        this.date=date;
        this.name=name;
        users=u;
        cars=c;
        drivers=d;
        commodities=cy;
        accounts=ba;
    }

    public String getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public ArrayList<UserPO> getUsers(){
        return users;
    }

    public ArrayList<CarPO> getCars(){
        return cars;
    }

    public ArrayList<DriverPO> getDrivers(){
        return drivers;
    }

    public ArrayList<CommodityPO> getCommoditys(){
        return commodities;
    }

    public ArrayList<BankAccountPO> getAccounts(){
        return accounts;
    }
//
//    public UserVO getWorkers(){
//        return users;
//    }
//
//    public CarVO getCars(){
//        return cars;
//    }
//
//    public DriverVO getDrivers(){
//        return drivers;
//    }
//
//    public CommodityVO getStorage(){
//        return storage;
//    }
//
//    public BankAccountVO getAccountInfo(){
//        return account;
//    }
}
