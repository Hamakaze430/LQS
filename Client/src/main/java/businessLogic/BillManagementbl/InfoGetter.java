package businessLogic.BillManagementbl;
import po.*;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by admin on 15/11/15.
 */

public class InfoGetter {

    public BillManagementPO getAll(String message){
        if(message.equals("create")){
            InfoGetter ig=new InfoGetter();
            BillManagementPO bill=new BillManagementPO(ig.getDate()
                    , ig.getName(), ig.getUsers(), ig.getCars(),
                    ig.getDrivers(), ig.getStorage(), ig.getAccount());
            return bill ;
        }
        else
            return null;
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

        return null;
    }
<<<<<<< Updated upstream

    public ArrayList<UserPO> getUsers(){
        ArrayList<UserPO> u=new ArrayList<UserPO>()
        return u;
    }

    public ArrayList<CarPO> getCars(){
        ArrayList<CarPO> c=new ArrayList<CarPO>()
        return c;
    }

    public ArrayList<DriverPO> getDrivers(){
        ArrayList<DriverPO> d=new ArrayList<DriverPO>()
        return d;
    }

    public ArrayList<CommodityPO> getStorage(){
        ArrayList<CommodityPO> cy=new ArrayList<CommodityPO>()
        return cy;
    }

    public ArrayList<BankAccountPO> getAccount(){
        ArrayList<BankAccountPO> ba=new ArrayList<BankAccountPO>()
        return ba;
    }
=======
//
//    public ArrayList<UserPO> getUsers(){
//        ArrayList<UserPO> u＝new ArrayList<UserPO>();
//        return u;
//    }
//
//    public ArrayList<CarPO> getCars(){
//        ArrayList<CarPO> c＝new ArrayList<CarPO>();
//        return c;
//    }
//
//    public ArrayList<DriverPO> getDrivers(){
//        ArrayList<DriverPO> d＝new ArrayList<DriverPO>();
//        return d;
//    }
//
//    public ArrayList<CommodityPO> getStorage(){
//        ArrayList<CommodityPO> cy＝new ArrayList<CommodityPO>();
//        return cy;
//    }
//
//    public ArrayList<BankAccountPO> getAccount(){
//        ArrayList<BankAccountPO> ba＝new ArrayList<BankAccountPO>();
//        return ba;
//    }
>>>>>>> Stashed changes
}
