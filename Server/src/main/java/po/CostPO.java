package po;

import java.io.Serializable;

public class CostPO implements Serializable{
	String cost;
	String earning;
	String profit;
	
	public CostPO(String c,String e,String p){
		cost = c;
		earning = e;
		profit = p;
	}
	
	public String getCost(){
		return cost;
	}
	
	public String getEarning(){
		return earning;
	}
	
	public String getProfit(){
		return profit;
	}

}
