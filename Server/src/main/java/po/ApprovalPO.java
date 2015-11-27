package po;

import java.io.Serializable;

/**
 * Created by admin on 15/10/25.
 */
public class ApprovalPO implements Serializable {
	public String name;
	public String creator;
	
	public ApprovalPO(String name,String creator){
		this.name=name;
		this.creator=creator;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getCreator(){
		return creator;
	}
	public void setCreator(String creater){
		this.creator=creator;
	}
}

