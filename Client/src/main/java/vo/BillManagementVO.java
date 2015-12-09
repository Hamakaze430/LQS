package vo;

import java.util.ArrayList;
import java.util.Iterator;

import po.BillManagementPO;
import po.UserPO;
import po.DriverPO;
import po.CarPO;
import po.CommodityPO;
import po.BankAccountPO;

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

    public BillManagementVO(BillManagementPO po){
    	date=po.getDate();
    	name=po.getName();
    	Iterator it=po.getUsers().iterator();
    	while(it.hasNext()){
    		users.add(new UserVO((UserPO)it.next()));
    	}
    	it=po.getCars().iterator();
    	while(it.hasNext()){
    		cars.add(new CarVO((CarPO)it.next()));
    	}
    	it=po.getDrivers().iterator();
    	while(it.hasNext()){
    		drivers.add(new DriverVO((DriverPO)it.next()));
    	}
    	it=po.getCommoditys().iterator();
    	while(it.hasNext()){
    		commodities.add(new CommodityVO((CommodityPO)it.next()));
    	}
    	it=po.getAccounts().iterator();
    	while(it.hasNext()){
    		accounts.add(new BankAccountVO((BankAccountPO)it.next()));
    	}
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
