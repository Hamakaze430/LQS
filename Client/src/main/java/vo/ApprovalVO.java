package vo;

import java.util.Vector;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalVO extends Vector<String> {
	
	
	public ApprovalVO(String name,String creater, String status, String hashId){
		this.add(name);
		this.add(creater);
		this.add(status);
		this.add(hashId);
	}
	
	public String getName(){
		return get(0);
	}
	public String getCreater(){
		return get(1);
	}
	public String getStatus(){
		return get(2);
	}
	public String getHashId(){
		return get(3);
	}
}

