package vo;

import java.util.ArrayList;

public class LogisticsVO {
	private String id;
	private ArrayList<State> state;
	
	public LogisticsVO(String id, ArrayList<State> state){
		this.id = id;
		this.state = state;
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	public ArrayList<State> getState(){
		return state;
	}
	public void setState(ArrayList<State> state){
		this.state = state;
	}
	
	public void addState(State state){
		this.state.add(state);
	}
}
