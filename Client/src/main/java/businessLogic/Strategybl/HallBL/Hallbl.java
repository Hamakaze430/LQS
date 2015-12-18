package businessLogic.Strategybl.HallBL;

import init.RMIHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businessLogicService.StrategyblService.HallblService;
import po.HallPO;
import dataService.ResultMessage;
import dataService.StrategydataService.HalldataService.HalldataService;
import vo.HallVO;

public class Hallbl implements HallblService{
	HalldataService hallDataService;
	
	public Hallbl() {
		// TODO Auto-generated constructor stub
	
		
		hallDataService = RMIHelper.getHallDataService();
	}
	
	
	public ResultMessage addHall(String name, String id, String location) {
		// TODO Auto-generated method stub
		
		HallPO po = new HallPO(name,id, location);
		
		try {
			return hallDataService.addHall(po) ;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public ResultMessage removeHall(String id) {
		// TODO Auto-generated method stub
		try {
			return  hallDataService.removeHall(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	public ArrayList<HallVO> showHall() {
		// TODO Auto-generated method stub
		try {
			return convertHallPO(hallDataService.showHall());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	
	
	public ArrayList<HallVO> convertHallPO (ArrayList<HallPO> polist){
		ArrayList<HallVO> halls = new ArrayList<HallVO>();
		
		for(int i=0;i<polist.size();i++){
			halls.add(new HallVO(polist.get(i).getID(), polist.get(i).getName(), null));
		}
		return halls;
	}


	


}
