package businessLogic.Strategybl.Constantbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ConstantVO;
import init.RMIHelper;
import dataService.ResultMessage;
import dataService.StrategydataService.ConstantdataService.ConstantdataService;
import businessLogic.Strategybl.CityInfo;
import businessLogicService.StrategyblService.ConstantblService;

public class Constantbl implements ConstantblService,CityInfo {
	
    public static ConstantdataService constantDataService = RMIHelper.getConstantDataService();
   
	public Constantbl() {
		// TODO Auto-generated constructor stub
	}
	

	public void addcity(String CityID) {
		// TODO Auto-generated method stub
		try {
			constantDataService.addCity(CityID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		try {
			constantDataService.setCityDistance(id1, id2, distance);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				return ResultMessage.SUCCESS;
	}

	public ResultMessage setPrice(double p) {
		// TODO Auto-generated method stub
		if (p <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.price = p;
		try {
			constantDataService.setPrice(p);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage setVehicleCost(double van, double railway,
			double airplane) {
		// TODO Auto-generated method stub
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.vanCost = van;
//		BasicValues.railwayCost = railway;
//		BasicValues.airplaneCost = airplane;
		
		try {
			constantDataService.setVehicleCost(van, railway, airplane);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
		// TODO Auto-generated method stub
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.FAILURE;
		
//		BasicValues.airplaneLoad = airplane;
//		BasicValues.vanLoad = van;
//		BasicValues.railwayLoad = railway;
		
		try {
			constantDataService.setVehicleLoad(van, railway, airplane);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ConstantVO getConstant() {
		// TODO Auto-generated method stub
				try {
					return new ConstantVO(constantDataService.getCityList(),
							constantDataService.getCityDistance(),
							constantDataService.getPrice()+"",
							constantDataService.getPrice()*18/23+"",
							constantDataService.getPrice()*25/23+"", 
							constantDataService.getVehicleCost()[0]+"",
							constantDataService.getVehicleCost()[1]+"", 
							constantDataService.getVehicleCost()[2]+"",
							constantDataService.getVehicleLoad()[0]+"", 
							constantDataService.getVehicleLoad()[1]+"",
							constantDataService.getVehicleLoad()[2]+"");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
}
	public static ArrayList<String> getCityList(){
		try {
			return constantDataService.getCityList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static ArrayList<String> getCityDistance(){
	try {
		return	constantDataService.getCityDistance();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
	
	
	
	public static double getPrice(){
		try {
			return constantDataService.getPrice();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static double[] getVehicleCost(){
		try {
			return constantDataService.getVehicleCost();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int[] getVehicleLoad(){
		try {
			return constantDataService.getVehicleLoad();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
