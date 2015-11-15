package data.dataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataService.dataFactoryService.DataFactoryService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService{

	protected DataFactory() throws RemoteException {
		super();
	}

}
