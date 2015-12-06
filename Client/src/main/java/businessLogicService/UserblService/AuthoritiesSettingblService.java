package businessLogicService.UserblService;

import java.util.List;

public interface AuthoritiesSettingblService {

	List<String> getList(String identity);

	boolean save(String tempText, List<String> tempList);

}
