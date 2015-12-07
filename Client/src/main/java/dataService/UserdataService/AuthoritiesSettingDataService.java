package dataService.UserdataService;

import java.rmi.Remote;
import java.util.List;

import po.AuthorityPO;


public interface AuthoritiesSettingDataService extends Remote {

	List<String> getList(String identity);

	boolean save(AuthorityPO authorityPO);
	 
}
