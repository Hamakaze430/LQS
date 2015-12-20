package init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.BankAccountdataService.BankAccountdataService;
import dataService.CarAndDriverdataService.CarAndDriverdataService;
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import dataService.ReceiptsdataService.ReceiptsdataService;
import dataService.StrategydataService.ConstantdataService.ConstantdataService;
import dataService.StrategydataService.HalldataService.HalldataService;
import dataService.StrategydataService.SalarydataService.SalarydataService;
import dataService.UserdataService.ApartmentDataService;
import dataService.UserdataService.AuthoritiesSettingDataService;
import dataService.UserdataService.UserdataService;



public class RMIHelper {

    private static final String IP = "localhost"; 

    private static boolean inited = false;

    private static LogisticsDataService logisticsData;
    
    private static BankAccountdataService bankaccountData;
    
    private static SalarydataService salaryData;
    
    private static ConstantdataService constantData;
    
    private static ApartmentDataService apartmentData;
    
	private static AuthoritiesSettingDataService authoritiesData;
	
	private static UserdataService userData;
	
	private static ReceiptsdataService receiptsData;
	
	private static CarAndDriverdataService carAndDriver;

    public synchronized static void init() throws ClientInitException {
        if (inited) {
            return;
        }

        try {
            initObjects();
            inited = true;
        } catch (Exception e) {
            throw new ClientInitException(e);
        }
    }

    private static void initObjects() throws MalformedURLException, RemoteException, NotBoundException {
        String urlPrefix = "rmi://" + IP + "/";
        logisticsData = (LogisticsDataService) Naming.lookup(urlPrefix + "logisticsData-Server");
        apartmentData = (ApartmentDataService) Naming.lookup(urlPrefix + "apartmentData-Server");
        authoritiesData = (AuthoritiesSettingDataService) Naming.lookup(urlPrefix + "authoritiesData-Server");
        userData = (UserdataService) Naming.lookup(urlPrefix + "userData-Server");
    	receiptsData = (ReceiptsdataService) Naming.lookup(urlPrefix + "receiptsData-Server");
    	carAndDriver = (CarAndDriverdataService) Naming.lookup(urlPrefix + "carAndDriverData-Server");
    }

    
    public static ApartmentDataService getApartmentData() {
		return apartmentData;
	}
    
    public static LogisticsDataService getLogisticsData() {
      return logisticsData;
  }

	public static BankAccountdataService getBankAccountdataService() {
		// TODO Auto-generated method stub
		return bankaccountData;
	}

	public static SalarydataService getSalaryDataService() {
		// TODO Auto-generated method stub
		return salaryData;
	}

	public static ConstantdataService getConstantDataService() {
		// TODO Auto-generated method stub
		return constantData;
	}

	public static AuthoritiesSettingDataService getAuthoritiesData() {
		// TODO Auto-generated method stub
		return authoritiesData;
	}
	
	public static UserdataService getUserData() {
		// TODO Auto-generated method stub
		return userData;
	}

	public static HalldataService getHallDataService() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ReceiptsdataService getReceiptsData() {
		// TODO Auto-generated method stub
		return receiptsData;
	}
	
	public static CarAndDriverdataService getCarAndDriverData() {
		// TODO Auto-generated method stub
		return carAndDriver;
	}
    
//    public static DataFactoryService getDataFactory() {
//        return df;
//    }
//
//	public static void main(String[] args) {
//		df = RMIHelper.getDataFactory();
//		//System.out.println("dfsfhsd");
//	}
}