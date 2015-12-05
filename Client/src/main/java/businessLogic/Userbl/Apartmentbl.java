package businessLogic.Userbl;

import java.util.ArrayList;
import java.util.List;

import vo.Place;
import businessLogicService.UserblService.ApartmentblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.HallPO;
import vo.HallVO;

public class Apartmentbl implements ApartmentblService {
	private DataFactoryService dataFactory;
	
	public Apartmentbl(){
		dataFactory = Client.dataFactory;
	}
	
	public List<HallVO> getAll() {
		List<HallPO> listPO = dataFactory.getApartmentDataService().findAll();
		
		List<HallVO> list = new ArrayList<HallVO>();
		for (HallPO po : listPO){
			HallVO vo = new HallVO(po.getName(),po.getID(),po.getLocation());
			list.add(vo);
		}
		return list;
		
	}

	public boolean insert(HallVO vo) {
		HallPO po = new HallPO(vo.getName(),vo.getID(),vo.getLocation());
		return dataFactory.getApartmentDataService().insert(po);
		
	}

	public int getNum(String s, Place place) {
//		int num = dataFactory.getApartmentDataService().getHallNum(s,place);
//		return num;
		return 0;
	}

}
