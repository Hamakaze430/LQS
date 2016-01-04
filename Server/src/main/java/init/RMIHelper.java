package init;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import data.Approvaldata.ApprovaldataImpl;
import data.BankAccountdata.BankAccountdataImpl;
import data.CarAndDriverdata.CarAndDriverDataServiceImpl;
import data.Constantdata.ConstantdataServiceImpl;
import data.CostBenefitdata.CostBenefitdataImpl;
import data.LogisticsInfoSearchdata.LogisticsDataServiceImpl;
import data.Receiptsdata.ReceiptsdataImpl;
import data.Salesdata.SalesdataImpl;
import data.Strategydata.SalarydataServiceImpl;
import data.Userdata.ApartmentDataServiceImpl;
import data.Userdata.AuthoritiesDataServiceImpl;
import data.Userdata.UserdataImpl;

public class RMIHelper {

    private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP = 
    		new HashMap<String, Class<? extends UnicastRemoteObject>>();
    
    private static final int PORT = 1099;

    private static boolean inited = false;

    static {
        NAMING_MAP.put("logisticsData-Server", LogisticsDataServiceImpl.class);
        NAMING_MAP.put("apartmentData-Server", ApartmentDataServiceImpl.class);
        NAMING_MAP.put("authoritiesData-Server", AuthoritiesDataServiceImpl.class);
        NAMING_MAP.put("userData-Server", UserdataImpl.class);
        NAMING_MAP.put("receiptsData-Server", ReceiptsdataImpl.class);
        NAMING_MAP.put("carAndDriverData-Server", CarAndDriverDataServiceImpl.class);
        NAMING_MAP.put("costBenefitData-Server", CostBenefitdataImpl.class);
        NAMING_MAP.put("salesData-Server", SalesdataImpl.class);
        NAMING_MAP.put("salaryData-Server", SalarydataServiceImpl.class);
        NAMING_MAP.put("bankaccountData-Server", BankAccountdataImpl.class);
        NAMING_MAP.put("approvalData-Server", ApprovaldataImpl.class);
        NAMING_MAP.put("constantData-Server", ConstantdataServiceImpl.class);
    }

    public synchronized static void init() throws ServerInitException {
        if (inited) {
            return;
        }
        try {
            LocateRegistry.createRegistry(PORT);
            for (Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP.entrySet()) {
                String name = entry.getKey();
                Class<? extends UnicastRemoteObject> clazz = entry.getValue();
                UnicastRemoteObject proxy = clazz.newInstance();
                Naming.rebind(name, proxy);
            }
            inited = true;
        } catch (Exception e) {
            throw new ServerInitException(e);
        }
    }
}
