package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LogisticsPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;//快递单号]
	private String currentState;
	private List<String> state;
	
	public LogisticsPO(String id, String currentState, List<String> state){
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
	

	public String getCurrentState(){
		return currentState;
	}
}
