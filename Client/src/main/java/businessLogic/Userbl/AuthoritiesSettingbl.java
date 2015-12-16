package businessLogic.Userbl;

import java.util.List;

import Miscellaneous.Authorities;
import businessLogicService.UserblService.AuthoritiesSettingblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.AuthorityPO;
/**
 * 权限管理的逻辑
 */
public class AuthoritiesSettingbl implements AuthoritiesSettingblService {
	
	private DataFactoryService dataFactory;
	
	public AuthoritiesSettingbl(){
		dataFactory = Client.dataFactory;
	}
	
	public List<String> getList(String identity) {
		return dataFactory.getAuthoritiesData().getList(identity);	
	}

	public boolean save(String tempText, List<String> tempList) {
		return dataFactory.getAuthoritiesData().save(new AuthorityPO(tempText, tempList));
	}
	
	public boolean hasTheAuthority(String identity , Authorities one) {
		List<String> list = getList(identity);
		for (String s : list){
			if (s.equals(one.toString())) return true;
		}
		return false;
	}

}
