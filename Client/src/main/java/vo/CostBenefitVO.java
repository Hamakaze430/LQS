package vo;

import java.util.Vector;

import po.CostBenefitPO;

/**
 * Created by admin on 15/10/25.
 */
public class CostBenefitVO extends Vector<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double cost;
	double benefit;
	double profit;
	
	public CostBenefitVO(CostBenefitPO po){
		this.add(po.getTotalPayment());
		this.add(po.getTotalIncome());
		this.add(po.getProfit());
	}
	
	public CostBenefitVO(String cost, String benefit, String profit){
		this.add(cost);
		this.add(benefit);
		this.add(profit);
	}
	
	public String getCost(){
		return get(0);
	}
	
	public String getBenefit(){
		return get(1);
	}
	
	public String getProfit(){
		return get(2);
	}
}
