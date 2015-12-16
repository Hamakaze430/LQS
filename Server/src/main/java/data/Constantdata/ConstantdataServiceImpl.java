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
	
	
	}

	@Override
	public void flush() throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.flush();
	}

	@Override
	public void setPrice(double price) throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setPrice(price);
	}

	@Override
	public double getPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getPrice();
	}

	@Override
	public void setVehicleCost(double van, double railway, double airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setVehicleCost(van, railway, airplane);
	}

	@Override
	public double[] getVehicleCost() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getVehicleCost();
	}

	@Override
	public void setVehicleLoad(int van, int railway, int airplane)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setVehicleLoad(van, railway, airplane);
	}

	@Override
	public int[] getVehicleLoad() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getVehicleLoad();
	}

	@Override
	public ArrayList<String> getCityList() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getCityList();
	}

	@Override
	public ArrayList<String> getCityDistance() throws RemoteException {
		// TODO Auto-generated method stub
		return constantDAO.getCityDistance();
	}

	@Override
	public void addCity(String CityID) throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.addCity(CityID);
	}

	@Override
	public void setCityDistance(String CityID1, String CityID2, double distance)
			throws RemoteException {
		// TODO Auto-generated method stub
		constantDAO.setCityDistance(CityID1, CityID2, distance);
	}

}
