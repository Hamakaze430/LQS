package businessLogicService.UserblService;

import java.util.List;

import vo.HallVO;


public interface ApartmentblService {
	
	String getName(String hallId);

	List<String> getHallNameListByAddress(String type, String string);

	HallVO getVOByName(String hallName);

	String getId(String string);
}
