package vo;

import java.util.ArrayList;

public class LogisticsVO {
	private String id;
	private ArrayList<LogisticsState> state;
	
	public LogisticsVO(String id, ArrayList<LogisticsState> state){
		this.id = id;
		this.state = state;
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	public ArrayList<LogisticsState> getState(){
		return state;
	}
	public void setState(ArrayList<LogisticsState> state){
		this.state = state;
	}
	
	public void addState(LogisticsState state){
		this.state.add(state);
	}
}
