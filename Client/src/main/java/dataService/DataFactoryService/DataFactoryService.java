package dataService.DataFactoryService;

import java.rmi.Remote;

<<<<<<< HEAD:Client/src/main/java/dataService/DataFactoryService/DataFactoryService.java
public interface DataFactoryService extends Remote {

	
	}




=======
import dataService.LogisticsInfoSearchdataService.LogisticsDataService;

public interface DataFactoryService extends Remote {
	
	LogisticsDataService getLogisticsDataService();
}

>>>>>>> 5e45caaeb5ff63c2803006ab061c2dc3f5106fbc:Client/src/main/java/dataService/DataFactoryService/DataFactoryService.java
