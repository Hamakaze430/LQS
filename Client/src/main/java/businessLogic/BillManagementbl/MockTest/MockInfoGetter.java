package businessLogic.BillManagementbl.MockTest;

import businessLogic.BillManagementbl.InfoGetter;
import po.*;

import java.util.*;

/**
 * Created by admin on 15/11/15.
 */
public class MockInfoGetter extends InfoGetter{

    public BillManagementPO getAll(String message){
        if(message.equals("create")){
            BillManagementPO bill=new BillManagementPO(this.getDate()
                    , this.getName(), this.getWorkers(), this.getCars(),
                    this.getDrivers(), this.getStorage(), this.getAccount());
            return bill;
        }
        else
            return null;
    }

    public String getDate(){
        return "2015/11/15";
    }

    public String getName(){
        return "LQS";
    }

    public ArrayList<UserPO> getWorkers(){
        UserPO u=new UserPO("1234", "1234", "36岁", "司机");
        ArrayList<UserPO> ul=new ArrayList<UserPO>();
        ul.add(u);
        return ul;
    }

    public ArrayList<CarPO> getCars(){
        CarPO c=new CarPO("001", "苏A2035", "2005/10/07");
        ArrayList<CarPO> cl=new ArrayList<CarPO>();
        cl.add(c);
        return cl;
    }
    
    public ArrayList<DriverPO> getDrivers(){
        DriverPO d=new DriverPO("001", "苏yy","男", "1985/10/07","1333333333","31345");
        ArrayList<DriverPO> dl=new ArrayList<DriverPO>();
        dl.add(d);
        return dl;
    }

    public ArrayList<CommodityPO> getStorage(){
        CommodityPO cy=new CommodityPO("0001", "2015/11/14", "普通", "南京", "289.5");
        ArrayList<CommodityPO> cyl=new ArrayList<CommodityPO>();
        cyl.add(cy);
        return cyl;
    }

    public ArrayList<BankAccountPO> getAccount(){
        BankAccountPO b=new BankAccountPO("一号账户", "123,0000");
        ArrayList<BankAccountPO> bl=new ArrayList<BankAccountPO>();
        bl.add(b);
        return bl;
    }
}
