package init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataService.dataFactoryService.DataFactoryService;


public class RMIHelper {

    private static final String IP = "localhost"; 

    private static boolean inited = false;

    private static DataFactoryService df;

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
        df = (DataFactoryService) Naming.lookup(urlPrefix + "dataFactoryService-dataService");
    }

    public static DataFactoryService getDataFactory() {
        return df;
    }

	public static void main(String[] args) {
		df = RMIHelper.getDataFactory();
	}
}