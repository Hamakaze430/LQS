package dataService.StrategydataService.ConstantdataService;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ConstantdataService extends Remote{

	public void flush();
	
	public void setPrice(double price);
	
	public double getPrice();
	
	public void setVehicleCost(double van, double railway, double airplane);
	
	public double[] getVehicleCost();
	
	public void setVehicleLoad(int van, int railway, int airplane);
	
	public int[] getVehicleLoad();
	
	public ArrayList<String> getCityList();
	
	public ArrayList<String> getCityDistance();
	
	public void addCity(String CityID);
	
	public void setCityDistance(String CityID1,String CityID2, double distance);
	
}
