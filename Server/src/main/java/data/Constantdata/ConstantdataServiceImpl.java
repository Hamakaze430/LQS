package data.Constantdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataService.StrategydataService.ConstantdataService.ConstantdataService;

public class ConstantdataServiceImpl extends UnicastRemoteObject implements ConstantdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	ConstantDAO constantDAO;
	
	
	
	
	
	public ConstantdataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	
		constantDAO = new ConstantFileDAO("constant");
		//constantDAO.flush();
	
	}

	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.flush();
	}

	public void setPrice(double price) throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setPrice(price);
	}

	public double getPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getPrice();
	}

	public void setVehicleCost(double van, double railway, double airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setVehicleCost(van, railway, airplane);
	}

	public double[] getVehicleCost() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getVehicleCost();
	}

	public void setVehicleLoad(int van, int railway, int airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setVehicleLoad(van, railway, airplane);
	}

	public int[] getVehicleLoad() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getVehicleLoad();
	}

	public ArrayList<String> getCityList() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getCityList();
	}

	public ArrayList<String> getCityDistance() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getCityDistance();
	}

	public void addCity(String CityID) throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.addCity(CityID);
	}

	public void setCityDistance(String CityID1, String CityID2, double distance)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setCityDistance(CityID1, CityID2, distance);
	}

}
