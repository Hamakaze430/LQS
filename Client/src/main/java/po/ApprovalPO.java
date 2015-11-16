package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalPO implements Serializable {
	public String name;
	public String creater;
	
	public ApprovalPO(String name,String creater){
		this.name=name;
		this.creater=creater;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getCreater(){
		return creater;
	}
	public void setCreater(String creater){
		this.creater=creater;
	}
}

