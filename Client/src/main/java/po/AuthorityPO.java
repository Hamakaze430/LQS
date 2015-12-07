package po;

import java.io.Serializable;
import java.util.List;

public class AuthorityPO implements Serializable{
	private String identity;
	private List<String> authorities;
	public AuthorityPO(String identity, List<String> authorities){
		this.identity = identity;
		this.authorities = authorities;
	}
	public List<String> getList(){
		return authorities;
	}
	public String getIdentity(){
		return identity;
	}
}