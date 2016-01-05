package businessLogic.Strategybl.Constantbl;

import java.util.ArrayList;

import vo.ConstantVO;
import init.Client;
import dataService.ResultMessage;
import dataService.StrategydataService.ConstantdataService.ConstantdataService;
import businessLogic.Strategybl.CityInfo;
import businessLogicService.StrategyblService.ConstantblService;

public class Constantbl implements ConstantblService,CityInfo {
	
    public static ConstantdataService constantDataService = Client.dataFactory.getConstantdataService();
   
	public Constantbl() {
		// TODO Auto-generated constructor stub
	}
	

	public void addcity(String CityID) {
		// TODO Auto-generated method stub
		
			constantDataService.addCity(CityID);
		
	}

	public ResultMessage setDistance(String id1, String id2, double distance) {
		// TODO Auto-generated method stub
		
			constantDataService.setCityDistance(id1, id2, distance);
			return ResultMessage.SUCCESS;
	}

	public ResultMessage setPrice(double p) {
		// TODO Auto-generated method stub
		if (p <= 0)
			return ResultMessage.FAILURE;
//		BasicValues.price = p;
		
			constantDataService.setPrice(p);
		
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
		
		
			constantDataService.setVehicleCost(van, railway, airplane);
		
		return ResultMessage.SUCCESS;
	}

	public ResultMessage setVehicleLoad(int van, int railway, int airplane) {
		// TODO Auto-generated method stub
		if (van <= 0 || railway <= 0 || airplane <= 0)
			return ResultMessage.FAILURE;
		
//		BasicValues.airplaneLoad = airplane;
//		BasicValues.vanLoad = van;
//		BasicValues.railwayLoad = railway;
		
		
			constantDataService.setVehicleLoad(van, railway, airplane);
		
		return ResultMessage.SUCCESS;
	}

	public ConstantVO getConstant() {
		// TODO Auto-generated method stub
				
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
				
}
	public static ArrayList<String> getCityList(){
		
			return constantDataService.getCityList();
		
	}
	
	
	public static ArrayList<String> getCityDistance(){
	
		return	constantDataService.getCityDistance();
	
	}
	
	
	
	
	public static double getPrice(){
		
			return constantDataService.getPrice();
		
	}
	
	
	public static double[] getVehicleCost(){
		
			return constantDataService.getVehicleCost();
		
	}
	
	
	public static int[] getVehicleLoad(){
		
			return constantDataService.getVehicleLoad();
		
	}
	
	
	
	
}
