package vo;

import java.util.List;

public class LogisticsVO {
	private String id;
	private List<String> state;
	
	public LogisticsVO(String id, List<String> state){
		this.id = id;
		this.state = state;
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	public List<String> getState(){
		return state;
	}
	public void setState(List<String> state){
		this.state = state;
	}
	
	public void addState(String state){
		this.state.add(state);
	}
}
