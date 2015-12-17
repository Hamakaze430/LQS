package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Place;
import vo.HallVO;

public interface ApartmentManagerblService {

	List<HallVO> getAll();

	boolean insert(HallVO vo,String type);


	int getNum(String text, String place);

	boolean delete(HallVO vo);

	boolean update(HallVO vo);

	List<String> getAllName();

	String getId(String hallName);
	
	String getName(String hallId);
}
