package init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;



public class RMIHelper {

    private static final String IP = "localhost"; 

    private static boolean inited = false;

    private static LogisticsDataService logisticsData;

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
    }

    public static LogisticsDataService getLogisticsData() {
      return logisticsData;
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