package vo;

import java.util.List;

public class LogisticsVO {
	private String id;
	private String currentState;
	private List<String> state;
	
	public LogisticsVO(String id, String currentState, List<String> state){
		this.id = id;
		this.currentState = currentState;
		this.state = state;
	}
	
	public String getId(){
		return id;
	}
	
	public List<String> getState(){
		return state;
	}
	
	public void addState(String state){
		this.state.add(state);
	}
	
	public String getCurrentState(){
		return currentState;
	}
}
