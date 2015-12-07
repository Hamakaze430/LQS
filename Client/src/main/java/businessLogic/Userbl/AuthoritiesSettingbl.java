package businessLogic.Userbl;

import java.util.List;

import businessLogicService.UserblService.AuthoritiesSettingblService;
import dataService.DataFactoryService.DataFactoryService;
import init.Client;
import po.AuthorityPO;

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

}
