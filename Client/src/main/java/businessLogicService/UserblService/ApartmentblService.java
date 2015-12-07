package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Place;
import vo.HallVO;

public interface ApartmentblService {

	List<HallVO> getAll();

	boolean insert(HallVO vo);


	int getNum(String text, Place place);

	boolean addNum(String text, Place place);

	boolean delete(HallVO vo);

	boolean update(HallVO vo);

	List<String> getAllName();

	String getId(String hallName);
	
	String getName(String hallId);

}
