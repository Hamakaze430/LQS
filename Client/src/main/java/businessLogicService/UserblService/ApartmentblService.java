package businessLogicService.UserblService;

import java.util.List;

import vo.HallVO;
import vo.Place;

public interface ApartmentblService {

	List<HallVO> getAll();

	boolean insert(HallVO vo);


	int getNum(String text, Place place);

}
