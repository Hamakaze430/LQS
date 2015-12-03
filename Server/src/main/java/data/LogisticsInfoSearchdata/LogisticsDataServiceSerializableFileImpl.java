package data.LogisticsInfoSearchdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataService.LogisticsInfoSearchdataService.LogisticsDataService;
import po.LogisticsPO;

public class LogisticsDataServiceSerializableFileImpl extends UnicastRemoteObject implements LogisticsDataService {

	protected LogisticsDataServiceSerializableFileImpl() throws RemoteException {
		super();
	}

	@Override
	public LogisticsPO find(String id) throws RemoteException {
		try {
			FileInputStream file = new FileInputStream("src/main/java/ser/logistics.ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		return null;
	}

	@Override
	public boolean insert(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	

}
