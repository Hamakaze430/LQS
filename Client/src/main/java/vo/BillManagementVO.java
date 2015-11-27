package vo;

import java.util.ArrayList;

import vo.*;

/**
 * Created by admin on 15/10/25.
 */
public class BillManagementVO {
	
	String date;
    String name;
    ArrayList<UserVO> users;
    ArrayList<CarVO> cars;
    ArrayList<DriverVO> drivers;
    ArrayList<CommodityVO> commodities;
    ArrayList<BankAccountVO> accounts;

    public BillManagementVO(String date, String name, ArrayList<UserVO> u, ArrayList<CarVO> c,
                   ArrayList<DriverVO> d, ArrayList<CommodityVO> cy, ArrayList<BankAccountVO> ba){
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

    public ArrayList<UserVO> getUsers(){
        return users;
    }

    public ArrayList<CarVO> getCars(){
        return cars;
    }

    public ArrayList<DriverVO> getDrivers(){
        return drivers;
    }

    public ArrayList<CommodityVO> getCommoditys(){
        return commodities;
    }

    public ArrayList<BankAccountVO> getAccounts(){
        return accounts;
    }
}
