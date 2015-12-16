package businessLogic.Userbl;

import java.util.ArrayList;
import java.util.List;

import Miscellaneous.Place;
import businessLogicService.UserblService.ApartmentManagerblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.HallPO;
import vo.HallVO;
/**
 * 部门管理的逻辑处理
 */
public class ApartmentManagerbl implements ApartmentManagerblService {
	private DataFactoryService dataFactory;
	
	public ApartmentManagerbl(){
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

	/**
	 * 增加部门信息
	 */
	public boolean insert(HallVO vo) {
		HallPO po = new HallPO(vo.getName(),vo.getID(),vo.getLocation());
		return dataFactory.getApartmentDataService().insert(po);
		
	}

	
	/**
	 * 得到对应部门的数量
	 */
	public int getNum(String text, Place place) {
//		int num = dataFactory.getApartmentDataService().getHallNum(s,place);
//		return num;
		int num = dataFactory.getApartmentDataService().getNum(text,place);
		return num;
	}

	/**
	 * 自增对应部门的数量
	 */
	public boolean addNum(String text, Place place) {
		return dataFactory.getApartmentDataService().addNum(text,place);
	}

	
	/**
	 * 删除部门信息
	 */
	public boolean delete(HallVO vo) {
		HallPO po = new HallPO(vo.getName(),vo.getID(),vo.getLocation());
		return dataFactory.getApartmentDataService().delete(po);
	}

	
	/**
	 * 更新部门信息
	 */
	public boolean update(HallVO vo) {
		HallPO po = new HallPO(vo.getName(),vo.getID(),vo.getLocation());
		return dataFactory.getApartmentDataService().update(po);
	}

	
	/**
	 * 得到部门信息列表
	 */
	public List<String> getAllName() {
		List<HallVO> list = getAll();
		List<String> ans = new ArrayList<String>();
		for (HallVO vo : list) ans.add(vo.getName());
		return ans;
	}

	/**
	 * 
	 */
	public String getId(String hallName) {
		HallPO po = dataFactory.getApartmentDataService().find("Name",hallName);
		return po.getID();
	}
	/**
	 * 
	 */
	public String getName(String hallId) {
		HallPO po = dataFactory.getApartmentDataService().find("Id",hallId);
		return po.getName();
	}
	

}
