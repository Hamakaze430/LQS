package businessLogicService.UserblService;

import java.util.List;

import Miscellaneous.Authorities;

public interface AuthoritiesSettingblService {

	List<String> getList(String identity);

	boolean save(String tempText, List<String> tempList);

	boolean hasTheAuthority(String identity , Authorities one);
}
